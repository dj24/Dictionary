/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacoursework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author pdu15gsu
 */
public class Trie extends TrieNode{
    private TrieNode root;
    
    public Trie(){
        this.root = new TrieNode();
    }
    

    public TrieNode getRoot(){
        return root;
    }
    
    public void setRoot(TrieNode node){
        this.root = node;
    }
    
    public boolean add(String key){
        if(this.contains(key)){
            return false;
        }
        TrieNode node = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(node.getChild(c) == null){
                node.addChild(c);
<<<<<<< HEAD
            }    
=======
            }
            if(i==key.length()-1){
                node.setComplete(true);
            }
>>>>>>> f4c71d7ebfbeb92064643cd7075d43aff5d707dd
            node.getChild(c).setParent(node);
            node = node.getChild(c);
        }
        node.setComplete(true);
        return true;
    }
    
    public boolean contains(String key){
        TrieNode node = root;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(node.getChild(c) == null){
                return false;
            }
            if(node.isComplete()){
                return true;
            }
            node = node.getChild(c);
        }
        return false;        
    }
    
    public String outputBreadthFirstSearch(){
        StringBuilder str = new StringBuilder();
        Queue<TrieNode> q = new LinkedList();
        q.add(this.root);
        while(!q.isEmpty()) {
                TrieNode child = q.peek().getUnvisitedChildNode();
                if(child != null) {
                        child.setVisited(true);
                        q.add(child);
                }
                else
                    str.append(q.remove().toString());
        }
        return str.toString();
    }
    
    public String outputDepthFirstSearch(){
        StringBuilder str = new StringBuilder();
        Stack<TrieNode> s = new Stack();
        s.push(this.root);
        while(!s.isEmpty()) {
                TrieNode child = s.peek().getUnvisitedChildNode();
                if(child != null) {
                        child.setVisited(true);
                        s.push(child);
                }
                else
                    str.append(s.pop().toString());
        }
        return str.toString();
    }
    
    public Trie getSubTrie(String prefix){
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.getChild(c) == null){
                return null;
            }
            else{
                node = node.getChild(c);
            }
            
        }
        Trie trie = new Trie();
        trie.setRoot(node);
        trie.getRoot().clearData();
        return trie;
    }
    
<<<<<<< HEAD
    /*
=======
    
>>>>>>> f4c71d7ebfbeb92064643cd7075d43aff5d707dd
    public String getAllWords(){
        StringBuilder str = new StringBuilder();
        List<String> l = new ArrayList();
        Stack<TrieNode> s = new Stack();
        s.push(this.root);
        while(!s.isEmpty()) {
                TrieNode child = s.peek().getUnvisitedChildNode();
                if(child != null) {
                        str.append(child.toString());
                        if(child.isComplete()){
                            l.add(str.toString());
                            str = new StringBuilder();
                        }
                        child.setVisited(true);
                        
                        s.push(child);
                        
                }
                else{
                    s.pop();
                }
        }
        return l.toString();
    }
<<<<<<< HEAD
    */
    
    public List<String> getAllWords(TrieNode node, String in){
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        Stack<TrieNode> s = new Stack<>();
        
        str.append(in).append(node.getC());
         
        for(TrieNode t : node.getOffspring()){
            if(t!=null) s.push(t);
        } 
        while(!s.empty()){
            list.addAll(getAllWords(s.pop(),str.toString()));
        }  
        if(node.isComplete()){
            list.add(str.toString());
        } 
        return list;
    }
    
=======
>>>>>>> f4c71d7ebfbeb92064643cd7075d43aff5d707dd
    
    @Override
    public String toString(){
        String newLine = System.getProperty("line.separator");
        StringBuilder str = new StringBuilder();
        str.append("ROOT NODE").append(newLine);
        str.append(root.toString()).append(newLine);
        str.append("OFFSPRING");
        for(TrieNode node : this.root.getOffspring()){
            if(node != null){
                str.append(newLine);
                str.append(node.toString());
            }      
        }
        return str.toString();
    }
    
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.add("cheers");
        trie.add("cheese");
        trie.add("chat");
        trie.add("cat");
        trie.add("bat");
       
        //System.out.println(trie.toString());
<<<<<<< HEAD
        System.out.println("all words: " + trie.getAllWords(trie.getRoot(),"").toString());
=======
        System.out.println("all words: " + trie.getAllWords());
>>>>>>> f4c71d7ebfbeb92064643cd7075d43aff5d707dd
        //System.out.println("bfs: " + trie.outputBreadthFirstSearch());
        //System.out.println("dfs: " + trie.outputDepthFirstSearch());
        
    }
}
