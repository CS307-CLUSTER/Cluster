package com.cluster.service;

import com.cluster.data.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by shane on 3/25/17.
 */

@Controller
public class RestarauntService {

    @Autowired
    private DatabaseController databaseController;

}
