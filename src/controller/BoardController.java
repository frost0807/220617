package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.BoardDTO;
import util.SUtil;

public class BoardController {
	private ArrayList<BoardDTO> list;
	private static Scanner sc;
	
	public BoardController(){
		list=new ArrayList<>();
		sc=new Scanner(System.in);
	}

	public ArrayList<BoardDTO> selectAll() {
		if(!list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	public void insert(BoardDTO b) {
		list.add(b);
	}

	public BoardDTO selectOne(int id) {
		BoardDTO b=new BoardDTO(id);
		if(list.contains(b)) {
			return list.get(list.indexOf(b));
		}
		return null;
	}

	public void delete(int id) {
		System.out.println("정말로 삭제하시겠습니까? Y/N");
		String yOrN=SUtil.nextLine(sc);
		if(yOrN.equalsIgnoreCase("y")) {
			list.remove(new BoardDTO(id));
		}
	}

	public void update(int id) {
		System.out.println("수정할 제목을 입력해주세요");
		selectOne(id).setTitle(SUtil.nextLine(sc));
		System.out.println("수정할 내용을 입력해주세요");
		selectOne(id).setContent(SUtil.nextLine(sc));
		
		list.set(list.indexOf(selectOne(id)),selectOne(id));
	}
}
