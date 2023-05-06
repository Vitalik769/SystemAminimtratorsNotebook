package com.example.Notebook.Controllers;

import com.example.Notebook.models.Post;
import com.example.Notebook.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TableController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/table")
    public String tableMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "item-one";
    }

    @GetMapping("/table/add")
    public String tableAdd(Model model) {
        return "item-add";
    }

    @PostMapping("/table/add")
    public String tablePostAdd(@RequestParam String Name, @RequestParam String IP, @RequestParam String AnyDesk, @RequestParam String TeamViewer, Model model) {
        Post post = new Post(Name, IP, AnyDesk, TeamViewer);
        postRepository.save(post);
        return "redirect:/table";
    }

    @GetMapping("/table/{id}")
    public String tableDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/table";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "item-details";
    }
    @GetMapping("/table/{id}/edit")
    public String tableEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/table";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "item-edit";
    }

    @PostMapping("/table/{id}/edit")
    public String tablePostUpdate(@PathVariable(value = "id") long id, @RequestParam String Name,  @RequestParam String IP, @RequestParam String AnyDesk, @RequestParam String TeamViewer, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setName(Name);
        post.setIP(IP);
        post.setAnyDesk(AnyDesk);
        post.setTeamViewer(TeamViewer);
        postRepository.save(post);

        return "redirect:/table";
    }
    @PostMapping("/table/{id}/remove")
    public String tablePostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/table";
    }

}
