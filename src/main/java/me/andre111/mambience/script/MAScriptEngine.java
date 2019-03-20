package me.andre111.mambience.script;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import me.andre111.mambience.MALogger;

public class MAScriptEngine {
	private MALogger logger;
	private ScriptEngine scriptEngine;
	
	protected MAScriptEngine(MALogger l, ScriptEngine se) {
		logger = l;
		scriptEngine = se;
	}
	
	public Object evalJS(String js) {
        try {
            return scriptEngine.eval(js);
        } catch (ScriptException ex) {
        	logger.error("Script failed\n" + js + "\n" + ex.getMessage());
        }
        
        return null;
    }
	
	public CompiledScript compileScript(String js) {
		Compilable compilingEngine = (Compilable) scriptEngine;
		try {
			CompiledScript script = compilingEngine.compile(js);
			script.eval(scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE));
			return script;
		} catch (ScriptException ex) {
			logger.error("Script compilation failed\n" + js + "\n" + ex.getMessage());
		}
		
		return null;
	}
	public Object invokeFunction(String name) {
		Invocable invocable = (Invocable) scriptEngine;
		try {
			return invocable.invokeFunction(name);
		} catch (NoSuchMethodException | ScriptException ex) {
			logger.error("Function invoke failed\n" + name + "\n" + ex.getMessage());
		}
		
		return null;
	}
	
	public Bindings getEngineScopeBindings() {
		return scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);
	}
	
	public void setValue(String name, Object value) {
		scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE).put(name, value);
	}
}