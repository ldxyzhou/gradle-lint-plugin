package com.zxy.gradle;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
/**
 * @author：xinyu.zhou
 * @version: 2018/5/30 14:05
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：xinyu.zhou@btcc.com
 */
public class CleanResPlugin implements Plugin<Project> {
    static final String GROUP = 'LintCleaner'
    static final String EXTENSION_NAME = 'lintCleaner'

    @Override
    void apply(Project project) {
        // 获取外部参数
        project.extensions.create(EXTENSION_NAME, PluginExtension, project)

        // 创建清理任务
        Task cleanTask = project.tasks.create(CleanTask.NAME, CleanTask)

        // 执行完lint后，再执行
        cleanTask.dependsOn project.tasks.getByName('lint')

    }
}