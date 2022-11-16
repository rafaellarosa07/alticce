package com.labs.alticci.controller;

import com.labs.alticci.service.AlticciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/altice")
public class AlticciController {

    private AlticciService alticciService;

    @Autowired
    public AlticciController(AlticciService alticciService) {
        this.alticciService = alticciService;
    }


    @GetMapping("/{n}")
    @Operation(
            summary = "Sequence index to get a value",
            description = "Find a value by index",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Request for Alticci sequence successful"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<?> calculate(@PathVariable("n") Integer number) {
        return ResponseEntity.ok(alticciService.getValueByIndex(number));
    }

}
