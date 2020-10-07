package com.app.codemate.controller;

import com.app.codemate.request.SnippetSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.app.codemate.request.SnippetExecuteRequest;
import com.app.codemate.response.Response;
import com.app.codemate.service.SnippetService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "snippet", produces = MediaType.APPLICATION_JSON_VALUE)
public class SnippetController {

    @Autowired
    private SnippetService snippetService;

    @CrossOrigin(origins = "*")
    @PostMapping("execute")
    public Response<?> execute(@RequestBody @Valid SnippetExecuteRequest request) {
        return new Response<>(snippetService.execute(request));
    }

    @GetMapping("execute-limit-reached")
    public Response<?> executeLimitReached() {
        return new Response<>(snippetService.executeLimitReached());
    }

    @PostMapping("save")
    public Response<?> save(@RequestBody @Valid SnippetSaveRequest request) {
        return new Response<>(snippetService.save(request));
    }

    @GetMapping("{uid}")
    public Response<?> getSnippet(@PathVariable("uid") String uid) {
        return new Response<>(snippetService.getSnippet(uid));
    }
}
