package hello.hellomemo.controller;

import hello.hellomemo.domain.Memo;
import hello.hellomemo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping(value = "/memos/new")
    public String createForm() {
        return "memos/createMemoForm";
    }

    @PostMapping(value = "/memos/new")
    public String create(MemoForm form) {
        Memo memo = new Memo();
        memo.setName(form.getName());

        memoService.join(memo);

        return "redirect:/";
    }

    @GetMapping(value = "/memos")
    public String list(Model model) {
        List<Memo> memos = memoService.findMemos();
        model.addAttribute("memos", memos);
        return "memos/memoList";
    }
}
