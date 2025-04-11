package com.example.Web.controllers;

import com.example.Web.entity.PostEntity;
import com.example.Web.repository.PostRepository;
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
//@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<PostEntity> postEntities = postRepository.findAll();
        model.addAttribute("posts",postEntities);
        return "blog_main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(){
        return "blog_add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text){
        PostEntity postEntity = new PostEntity(title, anons, full_text);
        postRepository.save(postEntity);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id,  Model model){
//        if(postRepository.existsById(id)){
//            return "/redirect:/blog";
//        }

        Optional<PostEntity> postEntity = postRepository.findById(id);
        ArrayList<PostEntity> res = new ArrayList<>();
        postEntity.ifPresent(res :: add);
        model.addAttribute("post", res);
        return "blog_details";

    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id,  Model model){
//        if(postRepository.existsById(id)){
//            return "/redirect:/blog";
//        }

        Optional<PostEntity> postEntity = postRepository.findById(id);
        ArrayList<PostEntity> res = new ArrayList<>();
        postEntity.ifPresent(res :: add);
        model.addAttribute("post", res);
        return "blog_edit";

    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text){
        PostEntity postEntity = postRepository.findById(id).orElseThrow();
        postEntity.setTitle(title);
        postEntity.setAnons(anons);
        postEntity.setFull_text(full_text);

        postRepository.save(postEntity);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id){
        PostEntity postEntity = postRepository.findById(id).orElseThrow();
        postRepository.delete(postEntity);
        return "redirect:/blog";
    }
}
