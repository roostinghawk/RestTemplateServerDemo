package com.edudigital.demo.controller;

import com.edudigital.demo.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * RestTemplate测试用Server端接口
 * @author liuwei
 * @date 2019/10/15
 */
@Slf4j
@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @RequestMapping(method = RequestMethod.GET)
    public List<TransactionDTO> getAll(){
        TransactionController.log.info("getAll");

        List<TransactionDTO> dtoList = new ArrayList<>();

        TransactionDTO dto1 = new TransactionDTO();
        dto1.setId(2018L);
        dto1.setPrice(101.5);
        dto1.setName("爱丁人1");
        dto1.setUpdateTime(new Date());

        TransactionDTO dto2 = new TransactionDTO();
        dto2.setId(2019L);
        dto2.setPrice(199D);
        dto2.setName("爱丁人2");
        dto2.setUpdateTime(new Date());

        dtoList.add(dto1);
        dtoList.add(dto2);

        return dtoList;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TransactionDTO get(@PathVariable Long id){
        TransactionController.log.info("get:" + id);

        TransactionDTO dto = new TransactionDTO();
        dto.setId(2019L);
        dto.setPrice(101.5);
        dto.setName("爱丁人1");
        dto.setUpdateTime(new Date());

        return dto;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody TransactionDTO dto){
        TransactionController.log.info("post:");
        TransactionController.log.info(dto.toString());

        return "post successfully!";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody TransactionDTO dto){
        TransactionController.log.info("put:");
        TransactionController.log.info(dto.toString());

        return "put successfully!";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        TransactionController.log.info("delete:" + id);

        return "delete successfully!";
    }
}
