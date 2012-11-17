package com.ccc.sendalyzeit.expertsystem.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccc.sendalyzeit.expertsystem.service.api.AnalyticsService;

@Controller
@RequestMapping("/observe")
public class ObservationController {
	@Inject
	private AnalyticsService analyticsService;
}
