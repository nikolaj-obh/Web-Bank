package dk.nikolaj.webbank.controllers;

import dk.nikolaj.webbank.model.Branch;
import dk.nikolaj.webbank.service.interfaces.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/branches")
public class BranchController {

    BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("")
    public List<Branch> list() {
        return branchService.listAllBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> get(@PathVariable Long id) {
        try {
            Branch branch = branchService.getBranch(id);
            return new ResponseEntity<Branch>(branch, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Branch branch) {
        branchService.saveBranch(branch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Branch branch, @PathVariable Long id) {
        try {
            Branch existBranch = branchService.getBranch(id);
            branch.setID(id);
            branchService.saveBranch(branch);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        branchService.deleteBranch(id);
    }
}
