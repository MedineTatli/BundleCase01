package main.controller;

import lombok.RequiredArgsConstructor;
import main.service.BundleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bundle")
@RequiredArgsConstructor
public class BundleController {

    private final BundleService bundleService;

    @PostMapping("/convertToList")
    public List<Integer> convertToArrayList(@RequestBody ArrayList<ArrayList<String>> request) {
        return bundleService.convertToDatas(request);
    }


}
