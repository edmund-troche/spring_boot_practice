package org.troche.spring.application.exercise.controller.v1;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to server as the base class for other controllers.
 *
 * This controller also handles the base URL path to use for the
 * version 1 API
 */
//@RequestMapping("api/v1")
@RequestMapping(UrlPath.BASE_PATH_V1)
public abstract class BaseController {
}
