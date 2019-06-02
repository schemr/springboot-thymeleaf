package kr.codelab.board.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import kr.codelab.board.entity.Board;
import kr.codelab.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public String getBoardList(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());

        return "board/list";
    }

    @GetMapping("/{id}")
    public String getBoard(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));

        return "board/detail";
    }

    @GetMapping("/new")
    public String newBoard(Board board) {
        return "board/new";
    }

    @PostMapping("/input")
    public String createBoard(Board board) {
        boardService.createBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}/edit")
    public String editBoard(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/edit";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }

}
