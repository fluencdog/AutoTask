package top.xjunz.tasker.engine.applet.criterion

import top.xjunz.tasker.engine.applet.base.Applet
import top.xjunz.tasker.engine.applet.serialization.AppletValues
import top.xjunz.tasker.engine.runtime.TaskRuntime

/**
 * @author xjunz 2022/08/25
 */
class EventCriterion(private val eventType: Int) : Applet() {

    override var valueType: Int = AppletValues.VAL_TYPE_INT

    override suspend fun apply(runtime: TaskRuntime) {
        val hit = runtime.events.find { it.type == eventType }
        if (hit == null) {
            runtime.isSuccessful = false
        } else {
            runtime.isSuccessful = true
            runtime.hitEvent = hit
        }
    }

}