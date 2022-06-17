package viewer;

import java.util.Scanner;
import controller.BoardController;
import model.BoardDTO;
import util.SUtil;

public class BoardViewer {

	public static int nextId;
	public static Scanner sc;
	public BoardController controller=new BoardController();
	
	public BoardViewer(){
		nextId=1;
		sc=new Scanner(System.in);
	}
	
	public void showMenu() {
		while(true) {
			System.out.println("1. 새 글 작성 2.글 목록 보기 3.종료");
			int userChoice=SUtil.nextInt(sc, 1, 3);
			if(userChoice==1) {
				write();
			} else if(userChoice==2) {
				printList();
			} else if(userChoice==3) {
				System.out.println("사용해 주셔서 감사합니다.");
				break;
			}
		}
	}
	private void printList() {
		if(controller.selectAll()!=null) {
			for(BoardDTO b:controller.selectAll()) {
				System.out.printf("%d. %s\n",b.getId(),b.getTitle());
			}
			System.out.println("상세보기 할 글의 번호나 뒤로 가시려면 0을 입력해주세요");
			int userChoice=SUtil.nextInt(sc);
			if(userChoice!=0&&!controller.selectAll().contains(new BoardDTO(userChoice))) {
				System.out.println("잘못된 입력입니다.");
			} else if(userChoice!=0) {
				printOne(userChoice);
			}
		} else {
				System.out.println("저장된 글이 없습니다.");
		}
	}
	private void printOne(int id) {
		System.out.println("글 번호:"+controller.selectOne(id).getId());
		System.out.println("글 작성자:"+controller.selectOne(id).getWriter());
		System.out.println("글 제목:"+controller.selectOne(id).getTitle());
		System.out.println("글 내용:"+controller.selectOne(id).getContent());
		
		System.out.println("1.삭제 2.수정 3.뒤로가기");
		int userChoice=SUtil.nextInt(sc, 1, 3);
		if(userChoice==1) {
			controller.delete(id);
		} else if(userChoice==2) {
			controller.update(id);
		}
	}
	public void write() {
		BoardDTO b=new BoardDTO(nextId++);
		System.out.println("제목을 입력해주세요");
		b.setTitle(SUtil.nextLine(sc));
		System.out.println("작성자를 입력해주세요");
		b.setWriter(SUtil.nextLine(sc));
		System.out.println("내용을 입력해주세요");
		b.setContent(SUtil.nextLine(sc));
		
		controller.insert(b);
	}
}
