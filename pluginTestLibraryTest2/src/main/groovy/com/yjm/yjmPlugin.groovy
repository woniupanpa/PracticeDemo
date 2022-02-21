package com.yjm
import org.gradle.api.Plugin
import org.gradle.api.Project
class yjmPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {

        project.task("aa") << {
            System.out.println("======================")
            System.out.println("happy birthday")
            System.out.println("======================")
        }
    }
}