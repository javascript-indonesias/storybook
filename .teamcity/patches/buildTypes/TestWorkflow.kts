package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'TestWorkflow'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("TestWorkflow")) {
    triggers {
        val trigger1 = find<VcsTrigger> {
            vcs {
                quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_DEFAULT
                triggerRules = "-:.teamcity/**"
                branchFilter = """
                    +:<default>
                    +:next
                    +:master
                    +:pull/*
                """.trimIndent()
            }
        }
        trigger1.apply {
            quietPeriodMode = VcsTrigger.QuietPeriodMode.DO_NOT_USE
        }
    }
}
