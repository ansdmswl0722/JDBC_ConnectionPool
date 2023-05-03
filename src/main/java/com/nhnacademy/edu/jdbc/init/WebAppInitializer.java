package com.nhnacademy.edu.jdbc.init;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;


/**
 * @Author : marco@nhnacademy.com
 * @Date : 05/04/2023
 */
@Slf4j
@HandlesTypes(
        value = {
                com.nhnacademy.edu.jdbc.Command.class
        }
)
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        ControllerFactory controllerFactory = new ControllerFactory();
        controllerFactory.init(c);
        ctx.setAttribute("controllerFactory", controllerFactory);

    }

}
