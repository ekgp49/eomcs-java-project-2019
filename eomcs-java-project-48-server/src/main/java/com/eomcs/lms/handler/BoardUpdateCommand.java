package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.stereotype.CommandMapping;
import com.eomcs.stereotype.Component;

@Component
public class BoardUpdateCommand {

  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @CommandMapping("/board/update")
  public void update(BufferedReader in, PrintWriter out) {
    try {
      out.print("번호?\n!{}!\n"); out.flush();
      int no = Integer.parseInt(in.readLine());

      Board board = boardDao.detail(no);
      if (board == null) { 
        out.println("해당 게시글을 찾을 수 없습니다.");
        return;
      }

      out.print("내용?\n!{}!\n"); out.flush();
      String input = in.readLine();
      if (input.length() > 0) 
        board.setContents(input);

      boardDao.update(board);

      out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      out.printf("%s : %s\n", e.toString(), e.getMessage());
    }
  }
}
