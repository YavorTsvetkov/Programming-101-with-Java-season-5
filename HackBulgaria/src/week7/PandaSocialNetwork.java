package week7;

import week7.Panda;
import java.util.*;

import java.sql.*;

/**
 * PandaSocialNetwork.java
 * @author yavor
 * 
 *Modeling a panda social network. The network is created with a graph,
 *where every vertex is a panda.
 */
public class PandaSocialNetwork  {
	/**
	 * Modeling the vertex of the graph
	 * @author yavor
	 *
	 */
	private class Vertex {
		
		private Panda panda;
		
		public Vertex(Panda panda) {
			this.panda = panda;
		}
		
		public Panda getPanda() {
			return this.panda;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			
			if (this == obj) {
				return true;
			}
			
			if (this.getClass().equals(obj.getClass())) {
				Vertex other = (Vertex)obj;
				
				if (this.panda.equals(other.panda)) {
					return true;
				}
			}
			
			return false;
		
		}
		
		@Override
		public int hashCode() {
			return panda.hashCode();
		}
		
	}
	
	//In this data structure we keep the vertices of the graph.
	//The key is every vertex (every panda).
	//The value is a list of the friends of the vertex. 
	private Map<Vertex, List<Vertex>> vertices;
	
	/**
	 * gets the count of the social network members
	 * @return the count of the social network members
	 */
	private int getMembersCount() {
		Set<Vertex> keySet = this.vertices.keySet();
		int count = keySet.size();
		return count;
	}
	
	/**
	 * returns a list of the friends of the panda
	 * @param panda - the panda whose friends we want
	 * @return list of friends
	 */
	private List<Vertex> getFriends(Panda panda) {
		Vertex member = new Vertex(panda);
		List<Vertex> friends = this.vertices.get(member);
		return friends;
	}
	
	/**
	 * return a friends list of the vertex
	 * @param target - 
	 * @return friends list
	 */
	private List<Vertex> getFriends(Vertex target) {
		List<Vertex> friends = this.vertices.get(target);
		return friends;
	}
	
	public PandaSocialNetwork(Panda newPanda) {
		Vertex newVertex = new Vertex(newPanda);
		this.vertices = new HashMap<Vertex, List<Vertex>>();
		this.vertices.put(newVertex, null);
	}
	
	public PandaSocialNetwork() {
		this.vertices = new HashMap<Vertex, List<Vertex>>();
	}
	
	/**
	 *  adding a panda to the social network. The panda has no friends for now. 
	 *  If the panda is already in the network don't add it again.
	 * @param panda - the panda to be added
	 */
	public void addPanda(Panda newPanda) {
		if (hasPanda(newPanda)) {
			return;
		}
		
		Vertex newVertex = new Vertex(newPanda);
		this.vertices.put(newVertex,  new ArrayList<Vertex>());
	}
	
	/**
	 * checking if a panda is present in the social network
	 * @param panda 
	 * @return true or false if the panda is in the network or not.
	 */
	public boolean hasPanda(Panda panda) {
		if (this.vertices.containsKey(new Vertex(panda))) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * making the two pandas friends
	 * @param firstPanda 
	 * @param secondPanda
	 */
	public void makeFriends(Panda firstPanda, Panda secondPanda) {
		if (!hasPanda(firstPanda)) {
			addPanda(firstPanda);
		}
		
		if (!hasPanda(secondPanda)) {
			addPanda(secondPanda);
		}
		
		
		Vertex firstPandaVertex = new Vertex(firstPanda);
		Vertex secondPandaVertex = new Vertex(secondPanda);
		
		//getting the friends lists of the two pandas
		List<Vertex> firstPandaFriends = this.vertices.get(firstPandaVertex);
		List<Vertex> secondPandaFriends = this.vertices.get(secondPandaVertex);
		
		//adding friends in the lists
		firstPandaFriends.add(secondPandaVertex);
		secondPandaFriends.add(firstPandaVertex);
		
		this.vertices.put(firstPandaVertex, firstPandaFriends);
		this.vertices.put(secondPandaVertex, secondPandaFriends);
	}
	
	/**
	 * checking if the two pandas are friends
	 * @param firstPanda
	 * @param secondPanda
	 * @return true or false if they are friends or not
	 */
	public boolean areFriends(Panda firstPanda, Panda secondPanda) {
		Vertex firstPandaVertex = new Vertex(firstPanda);
		Vertex secondPandaVertex = new Vertex(secondPanda);
		
		//retrieving the two pandas friends lists
		List<Vertex> firstPandaFriends = getFriends(firstPandaVertex);
		List<Vertex> secondPandaFriends = getFriends(secondPandaVertex);
		
		//checking if the two pandas are friends
		if (firstPandaFriends.contains(secondPandaVertex) 
				&& secondPandaFriends.contains(firstPandaVertex)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * checking the connection level between two pandas
	 * @param firstPanda
	 * @param secondPanda
	 * @return 1 if two pandas are friends. Otherwise return the number of friends
	 * needed to go through firstPanda to secondPanda. If they are not connected at all
	 * return -1
	 */
	public int connectionLevel(Panda firstPanda, Panda secondPanda) {
		
		if (firstPanda.equals(secondPanda)) {
			throw new IllegalArgumentException("Please enter two different pandas!");
		}
		
		//checking if first panda is not part of
		//the social network
		if (!hasPanda(firstPanda)) {
			throw new IllegalArgumentException("" + firstPanda.getName() + "is not memeber of"
					+ "the social network!");
		}
		
		//checking if second panda is not part of
		//the social network
		if (!hasPanda(secondPanda)) {
			throw new IllegalArgumentException("" + secondPanda.getName() + 
					"is not member of the social network");
		}
		
		if (areFriends(firstPanda, secondPanda)) {
			return 1;
		}
		
		//if secondPanda has no friends return -1
		if (getFriends(secondPanda).isEmpty()) {
			return -1;
		}
		
		Vertex firstPandaVertex = new Vertex(firstPanda);
		Vertex secondPandaVertex = new Vertex(secondPanda);
		
		int counter = 0;
		counter = countConnectionLevel(firstPandaVertex, secondPandaVertex, counter);
		
		return counter;
	}
	
	//used for store the friends that we check 
	private List<Vertex> checkedFriends = new ArrayList<Vertex>();
	
	private int countConnectionLevel(Vertex start, Vertex target, int counter) {
		List<Vertex> friends = getFriends(start);
		checkedFriends.add(start);
		counter++;
		
		//if the friends list of the current panda 
		//contains the target panda, return counter
		if (friends.contains(target)) {
			return counter;
		}
		
		for (Vertex friend : friends) {
			
			if (!checkedFriends.contains(friend)) {
				
				return countConnectionLevel(friend, target, counter);				
			}
		}
		
		//no friendship
		return -1;
	}
	
	/**
	 * checking if the two pandas are somehow connectedtrue friends
	 * in the network.
	 * @param firstPanda
	 * @param secondPanda
	 * @return true if pandas are connected somehow true friends
	 * or false otherwise
	 */
	public boolean areConnected(Panda firstPanda, Panda secondPanda) {
		int connection = connectionLevel(firstPanda, secondPanda);
		
		if (connection >= 1) {
			return true;
		}	
		
		return false;
	}  
}

