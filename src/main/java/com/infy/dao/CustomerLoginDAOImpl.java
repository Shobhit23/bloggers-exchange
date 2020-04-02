package com.infy.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.infy.entity.CustomerLoginEntity;
import com.infy.entity.UserEntity;
import com.infy.model.User;
import com.infy.model.CustomerLogin;

@Repository
public class CustomerLoginDAOImpl implements CustomerLoginDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public CustomerLogin getCustomerLoginByLoginName(String loginName) {
		String id = null;
		int followers = 0;
		int following = 0;
		Object fullname = null;
		Object category = null;
		int postcount = 0;
		final CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = "https://www.instagram.com/"+loginName+"/?__a=1";
		
		
		try {
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			
			
			BufferedReader  in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine())!=null) {
				response.append(inputLine);
			}
			in.close();
			
			JSONObject myresponse = new JSONObject(response.toString());
			
			
			JSONObject myresponse_graphql = (JSONObject) myresponse.get("graphql");
			JSONObject myresponse_user = (JSONObject) myresponse_graphql.get("user");
			JSONObject myresponse_edge_followed_by = (JSONObject) myresponse_user.get("edge_followed_by");
			followers = (int) myresponse_edge_followed_by.get("count");
			JSONObject myresponse_edge_follow = (JSONObject) myresponse_user.get("edge_follow");
			following = (int) myresponse_edge_follow.get("count");
			fullname =  myresponse_user.get("full_name");
			if(fullname!=null) {
				fullname.toString();
			} 
			category =  myresponse_user.get("business_category_name");
			if(category!=null) {
				category.toString();
			}
			JSONObject myresponse_edge_owner_to_timeline_media = (JSONObject) myresponse_user.get("edge_owner_to_timeline_media");
			postcount = (int) myresponse_edge_owner_to_timeline_media.get("count");
			
			id = (String) myresponse_user.get("id");
			
			
			
	}
		catch(Exception e){
			if(e.getMessage()=="FileNotFoundException") {
				return null;
			}
			e.printStackTrace();
		}
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.setLoginName(id);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userEntity.setUsername(loginName);
		userEntity.setFollowers(followers);
		userEntity.setFollowing(following);
		userEntity.setFullname(fullname.toString());
		userEntity.setCategory(category.toString());
		userEntity.setPostcount(postcount);
		
		String queryString = "select u.id from UserEntity u";
		Query query = entityManager.createQuery(queryString);
		List<String> result = query.getResultList();
		
		if(!result.contains(userEntity.getId()))
		{
		entityManager.persist(userEntity);
		}
		
		return customerLogin;
}
	
	
	
		
		


	@Override
	public List<User> showTabel() {
		
		String queryString = "select u from UserEntity u";
		Query query = entityManager.createQuery(queryString);
		List<UserEntity> result = query.getResultList();
		
		
		List<User> userList = new ArrayList<User>();
		
		for(UserEntity userEntity : result) {
			User user = new User();
			user.setId(userEntity.getId());
			user.setPrimarykey(userEntity.getPrimarykey());
			user.setUsername(userEntity.getUsername());
			user.setFullname(userEntity.getFullname());
			user.setFollowers(userEntity.getFollowers());
			user.setFollowing(userEntity.getFollowing());
			user.setCategory(userEntity.getCategory());
			user.setPostcount(userEntity.getPostcount());
			userList.add(user);
		}
		
		
		return userList;
		
	}

}