/*
	Name: Keith Radford
	Student ID: V00918086
*/ 

import java.awt.Color;
import java.util.*;

public class GraphAlgorithms{
	/* FloodFillDFS(v, writer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour){
		LinkedList<PixelVertex> visited = new LinkedList<PixelVertex>();
		DFS(v, writer, fillColour, visited);
	}

	public static void DFS(PixelVertex v, PixelWriter writer, Color fillColour, LinkedList visited){
		writer.setPixel(v.getX(), v.getY(), fillColour);
		visited.add(v);

		LinkedList<PixelVertex> neighbours = v.getNeighbours();
		int neighbours_len = neighbours.size();
		int visited_len = visited.size();
		Boolean new_vertex;
		for(int i = 0; i < neighbours_len; i++){
			new_vertex = true;
			for(int j = 0; j < visited_len; j++){
				if(neighbours.get(i).equals(visited.get(j))){
					new_vertex = false;
					break;
				}
			}
			if(new_vertex){
				DFS(neighbours.get(i), writer, fillColour, visited);
			}
		}
	}
	
	/* FloodFillBFS(v, writer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			writer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour){
		LinkedList<PixelVertex> neighbours;
		int neighbours_len;
		int visited_len;
		Boolean new_vertex;

		LinkedList<PixelVertex> visited = new LinkedList<PixelVertex>();

		writer.setPixel(v.getX(), v.getY(), fillColour);
		Queue<PixelVertex> queue = new ArrayDeque<PixelVertex>();
		queue.add(v);
		visited.add(v);

		while(!queue.isEmpty()){
			v = queue.poll();
			visited_len = visited.size();
			neighbours = v.getNeighbours();
			neighbours_len = neighbours.size();
			for(int i = 0; i < neighbours_len; i++){
				new_vertex = true;
				for(int j = 0; j < visited_len; j++){
					if(neighbours.get(i).equals(visited.get(j))){
						new_vertex = false;
						break;
					}
				}
				if(new_vertex){
					visited.add(neighbours.get(i));
					writer.setPixel(v.getX(), v.getY(), fillColour);
					queue.add(neighbours.get(i));
				}
			}
		}
	}
	
}