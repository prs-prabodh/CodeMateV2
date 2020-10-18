package com.app.codemate.controller;

import com.app.codemate.request.SnippetSaveRequest;
import com.app.codemate.util.Constants;
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

    /**
     * Execute a code snippet against an input and return output.
     *
     * Consumer - Snippy Frontend
     * @param request Object containing code snippet, language and I/O
     * @return Object containing output with quantity of resources used or error.
     */
    @CrossOrigin(origins = "*")
    @PostMapping("execute")
    public Response<?> execute(@RequestBody @Valid SnippetExecuteRequest request) {
        return new Response<>(snippetService.execute(request));
    }

    /**
     * Returns if daily API limit has been reached on JDoodle.
     * Current daily limit is 200.
     *
     * Consumer - Not used on production. For debug purposes only.
     * @return Boolean wrapped in Response
     */
    @GetMapping("execute-limit-reached")
    public Response<?> executeLimitReached() {
        return new Response<>(snippetService.executeLimitReached());
    }

    /**
     * Save code snippets along with language and I/O
     *
     * Consumer - Snippy Frontend
     * @param request Object containing code snippet, language and I/O
     * @return Object containing UID of saved snippet
     */
    @CrossOrigin(origins = "*")
    @PostMapping("save")
    public Response<?> save(@RequestBody @Valid SnippetSaveRequest request) {
        return new Response<>(snippetService.save(request));
    }

    /**
     * Returns code snippet with selected language and I/O
     *
     * Consumer - Snippy Frontend
     * @param uid UID of saved snippet
     * @return Object containing code snippet UID, wrapped in Response
     */
    @CrossOrigin(origins = "*")
    @GetMapping("{uid}")
    public Response<?> getSnippet(@PathVariable("uid") String uid) {
        return new Response<>(snippetService.getSnippet(uid));
    }

    /**
     * Overwrite code snippet attributes. Used to change
     * snippet attributes after initial save.
     *
     * Consumer - Snippy Frontend
     * @param request Object containing edited values of snippet
     * @param uid UID of snippet
     * @return Object containing code snippet UID, wrapped in Response
     */
    @CrossOrigin(origins = "*")
    @PutMapping("{uid}")
    public Response<?> editSnippet(@RequestBody SnippetSaveRequest request, @PathVariable("uid") String uid) {
        return new Response<>(snippetService.editSnippet(request, uid));
    }
}
