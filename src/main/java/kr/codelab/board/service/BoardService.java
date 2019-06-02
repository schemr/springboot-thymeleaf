package kr.codelab.board.service;

import kr.codelab.board.entity.Board;
import kr.codelab.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BoardService {
    private BoardRepository boardRepository;

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElse(new Board());
    }

    public void createBoard(Board board) {
        board.setCurrentTime();
        boardRepository.save(board);
    }

    public void updateBoard(Board board) {
        Board savedBoard = boardRepository.findById(board.getId()).get();
        savedBoard.update(board);
        boardRepository.save(savedBoard);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
