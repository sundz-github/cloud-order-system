package com.cloud.score.Controller;

import com.cloud.common.entity.ScoreVO;
import com.cloud.score.service.CloudScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:26
 */
@RestController
@RequestMapping("score")
public class CloudScoreController {

    @Autowired
    private CloudScoreService scoreService;


    @PostMapping("commit")
    public Integer commit(@RequestBody @Validated ScoreVO scoreVO) {
        return scoreService.commit(scoreVO);
    }


    @GetMapping("{id}")
    public ScoreVO query(@PathVariable("id") Integer id) throws Exception {
        return scoreService.query(id);
    }

}
