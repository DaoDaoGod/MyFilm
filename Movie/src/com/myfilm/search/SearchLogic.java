package com.myfilm.search;
import java.io.BufferedReader;
import java.io.File;   
import java.io.InputStreamReader;
import java.sql.Connection;   
import java.sql.ResultSet;   
import java.sql.Statement;   
import java.util.ArrayList;   
import java.util.HashSet;
import java.util.List;   
import java.util.Set;  
import org.apache.lucene.analysis.Analyzer;   
import org.apache.lucene.document.Document;   
import org.apache.lucene.document.Field;   
import org.apache.lucene.document.Field.TermVector;   
import org.apache.lucene.index.IndexWriter;   
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;   
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKSimilarity;   

import com.myfilm.bean.FilmBean;
  
/**    
* SearchLogic.java  
* @version 1.0  
* @createTime Lucene数据库检索  
*/  
public class SearchLogic {   
	private static Connection conn = null;   
	private static Statement stmt = null;   
	private static  ResultSet rs = null;   
	private String searchDir = "H:\\Test\\Index";   
	private static File indexFile = null;   
	private static Searcher searcher = null;   
	private static Analyzer analyzer = null;   
	/** 索引页面缓冲 */  
	private int maxBufferedDocs = 500;   
	/**  
	* 获取数据库数据  
	* @return ResultSet  
	* @throws Exception  
	*/  
	public List<SearchBean> getResult(String queryStr) throws Exception {   
		List<SearchBean> result = null;   
		conn = JdbcUtil.getConnection();   
		if(conn == null) {   
			throw new Exception("数据库连接失败！");   
		}   
		System.out.println("数据库连接成功！");
		String sql = "select film.film_id,film.name,film.othername,film.director,actor.actor from film,actor,film_actor where film.film_id=film_actor.film_id and actor.actor_id=film_actor.actor_id";    
		try {   
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); 
			this.createIndex(rs);   //给数据库创建索引,此处执行一次，不要每次运行都创建索引，以后数据有更新可以后台调用更新索引   
			TopDocs topDocs = this.searchName(queryStr);   
			TopDocs topDocs2 = this.searchNickname(queryStr);  
			TopDocs topDocs3 = this.searchDirector(queryStr);  
			TopDocs topDocs4 = this.searchActor(queryStr);  
			ScoreDoc[] scoreDocs  = topDocs.scoreDocs; 
			ScoreDoc[] scoreDocs2 = topDocs2.scoreDocs; 
			ScoreDoc[] scoreDocs3 = topDocs3.scoreDocs; 
			ScoreDoc[] scoreDocs4 = topDocs4.scoreDocs; 
			Set<String> exist_id =new HashSet<String>();
			result = this.addHits2List(scoreDocs,exist_id);
			result.addAll(this.addHits2List(scoreDocs2,exist_id));
			result.addAll(this.addHits2List(scoreDocs3,exist_id));
			result.addAll(this.addHits2List(scoreDocs4,exist_id));
		} catch(Exception e) {   
			e.printStackTrace();   
			throw new Exception("数据库查询sql出错！ sql : " + sql);   
		} finally {   
			if(rs != null) rs.close();   
			if(stmt != null) stmt.close();   
			if(conn != null) conn.close();   
		}            
		return result;   
	}   

/**  
* 为数据库检索数据创建索引  
* @param rs  
* @throws Exception  
*/  
	private void createIndex(ResultSet rs) throws Exception {   
		Directory directory = null;   
		IndexWriter indexWriter = null;   
	   
		try {   
			indexFile = new File(searchDir);   
			if(!indexFile.exists()) {   
				indexFile.mkdir();   
			}   
			directory = FSDirectory.open(indexFile);   
			analyzer = new IKAnalyzer();   
			indexWriter = new IndexWriter(directory, analyzer, true, IndexWriter.MaxFieldLength.UNLIMITED);   
			indexWriter.setMaxBufferedDocs(maxBufferedDocs);   
			Document doc = null;   
			while(rs.next()) {   
				doc = new Document();   
				Field id = new Field("film_id", String.valueOf(rs.getInt("film_id")), Field.Store.YES, Field.Index.NOT_ANALYZED, TermVector.NO);   
				Field name = new Field("name", rs.getString("name") == null ? "" : rs.getString("name"), Field.Store.YES,Field.Index.ANALYZED, TermVector.NO);  
				Field othername = new Field("othername", rs.getString("othername") == null ? "" : rs.getString("othername"), Field.Store.YES,Field.Index.ANALYZED, TermVector.NO);
				Field director = new Field("director", rs.getString("director") == null ? "" : rs.getString("director"), Field.Store.YES,Field.Index.ANALYZED, TermVector.NO); 
				Field actor = new Field("actor", rs.getString("actor") == null ? "" : rs.getString("actor"), Field.Store.YES,Field.Index.ANALYZED, TermVector.NO); 
				doc.add(id);   
				doc.add(name);  
				doc.add(othername);
				doc.add(director);
				doc.add(actor);
		
				indexWriter.addDocument(doc);   
			}   
		               
			indexWriter.optimize();   
			indexWriter.close();   
		} catch(Exception e) {   
			e.printStackTrace();   
		}    
	}   
 
	/**  
	* 搜索索引  
	* @param queryStr  
	* @return  
	* @throws Exception  
	*/  
	private TopDocs searchName(String queryStr) throws Exception {   		
		if(searcher == null) {   
			indexFile = new File(searchDir);   
			searcher = new IndexSearcher(FSDirectory.open(indexFile));     
		}   
		searcher.setSimilarity(new IKSimilarity());   
		QueryParser parser = new QueryParser(Version.LUCENE_30,"name",new IKAnalyzer());   	
		Query query = parser.parse(queryStr);	
		TopDocs topDocs = searcher.search(query, searcher.maxDoc());   
		return topDocs;   
	}
	/**  
	* 搜索索引  
	* @param queryStr  
	* @return  
	* @throws Exception  
	*/  
	private TopDocs searchNickname(String queryStr) throws Exception {   		
		if(searcher == null) {   
			indexFile = new File(searchDir);   
			searcher = new IndexSearcher(FSDirectory.open(indexFile));     
		}   
		searcher.setSimilarity(new IKSimilarity());   
		QueryParser parser = new QueryParser(Version.LUCENE_30,"othername",new IKAnalyzer());   	
		Query query = parser.parse(queryStr);	
		TopDocs topDocs = searcher.search(query, searcher.maxDoc());   
		return topDocs;   
	}
	
	/**  
	* 搜索索引  
	* @param queryStr  
	* @return  
	* @throws Exception  
	*/  
	private TopDocs searchDirector(String queryStr) throws Exception {   		
		if(searcher == null) {   
			indexFile = new File(searchDir);   
			searcher = new IndexSearcher(FSDirectory.open(indexFile));     
		}   
		searcher.setSimilarity(new IKSimilarity());   
		QueryParser parser = new QueryParser(Version.LUCENE_30,"director",new IKAnalyzer());   	
		Query query = parser.parse(queryStr);	
		TopDocs topDocs = searcher.search(query, searcher.maxDoc());   
		return topDocs;   
	}
	
	/**  
	* 搜索索引  
	* @param queryStr  
	* @return  
	* @throws Exception  
	*/  
	private TopDocs searchActor(String queryStr) throws Exception {   		
		if(searcher == null) {   
			indexFile = new File(searchDir);   
			searcher = new IndexSearcher(FSDirectory.open(indexFile));     
		}   
		searcher.setSimilarity(new IKSimilarity());   
		QueryParser parser = new QueryParser(Version.LUCENE_30,"actor_name",new IKAnalyzer());   	
		Query query = parser.parse(queryStr);	
		TopDocs topDocs = searcher.search(query, searcher.maxDoc());   
		return topDocs;   
	}
	
	/**  
	* 返回结果并添加到List中  
	* @param scoreDocs  
	* @return  
	* @throws Exception  
	*/  
	private List<SearchBean> addHits2List(ScoreDoc[] scoreDocs ,Set<String> exist_id) throws Exception {   
		List<SearchBean> listBean = new ArrayList<SearchBean>();   
		SearchBean bean = null;   
		for(int i=0 ; i<scoreDocs.length; i++) {
			int docId = scoreDocs[i].doc;   
			Document doc = searcher.doc(docId);  
			if(!exist_id.contains(doc.get("film_id"))){ 
			exist_id.add(doc.get("film_id"));
			bean = new SearchBean();   
			bean.setId(doc.get("film_id"));   
			bean.setName(doc.get("name"));   
			bean.setNickname(doc.get("othername"));  
			bean.setNickname(doc.get("director"));
			bean.setNickname(doc.get("actor"));
			listBean.add(bean);   
			}
		}   
		return listBean;   
	}
	
	public List<FilmBean> getsearchvalue(String text)
	{
		
		List<FilmBean> filmList=new ArrayList<FilmBean>();
		try {    
	
			Long startTime = System.currentTimeMillis(); 
			List<SearchBean> result = getResult(text);   
			int i = 0;   
			for(SearchBean bean : result) {   
				if(i == 100) 
					break;   
				String sqlurl="select photolink from photo where photo.film_id="+bean.getId();
		        Connection conn;
				conn = JdbcUtil.getConnection(); 
	            Statement stmtx = conn.createStatement(); 
				ResultSet rsx = stmtx.executeQuery(sqlurl); 
				String s1 =null;
				while (rsx.next()){
			       s1 = rsx.getString(1); 
				}
				int film_id=Integer.parseInt(bean.getId());
				System.out.println("bean.name " + bean.getClass().getName() + " : bean.film_id " +film_id+ " : bean.name " + bean.getName()+ " : bean.photo "+s1);
				FilmBean newFilmBean=new FilmBean();
				newFilmBean.setFilmId(film_id);
				newFilmBean.setName(bean.getName());
			    newFilmBean.setFilmlink(s1);
			    filmList.add(newFilmBean);
                rsx.close();
                stmtx.close();
				i++;   
			}
			
			System.out.println("searchBean.result.size : " + result.size());   
			Long endTime = System.currentTimeMillis();   
			System.out.println("查询所花费的时间为：" + (endTime-startTime)/1000);   
		} catch (Exception e) { 
			e.printStackTrace();   
			System.out.println(e.getMessage());   
		}   
		return filmList;
	}
	
	/*public static void main(String[] args) {   
		SearchLogic logic = new SearchLogic();   
		try {    
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入要查询的内容:"); 
			String text=br.readLine();
			Long startTime = System.currentTimeMillis(); 
			List<SearchBean> result = logic.getResult(text);   
			int i = 0;   
			for(SearchBean bean : result) {   
				if(i == 100) 
					break;   
				String sqlurl="select photolink from photo where photo.film_id="+bean.getId();
		        Connection conn;
				conn = JdbcUtil.getConnection(); 
	            Statement stmtx = conn.createStatement(); 
				ResultSet rsx = stmtx.executeQuery(sqlurl); 
				String s1 =null;
				while (rsx.next()){
			       s1 = rsx.getString(1); 
				}
				int film_id=Integer.parseInt(bean.getId());
				System.out.println("bean.name " + bean.getClass().getName() + " : bean.film_id " +film_id+ " : bean.name " + bean.getName()+ " : bean.photo "+s1); 
                rsx.close();
                stmtx.close();
				i++;   
			}
			
			System.out.println("searchBean.result.size : " + result.size());   
			Long endTime = System.currentTimeMillis();   
			System.out.println("查询所花费的时间为：" + (endTime-startTime)/1000);   
		} catch (Exception e) { 
			e.printStackTrace();   
			System.out.println(e.getMessage());   
		}   
}*/
}