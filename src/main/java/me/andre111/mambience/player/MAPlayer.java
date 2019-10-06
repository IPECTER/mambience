/*
 * Copyright (c) 2019 André Schweiger
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.andre111.mambience.player;

import java.util.HashMap;
import java.util.UUID;

import javax.script.CompiledScript;

import me.andre111.mambience.MALogger;
import me.andre111.mambience.scan.BlockScanner;
import me.andre111.mambience.script.MAScriptEngine;
import me.andre111.mambience.script.MAScripting;
import me.andre111.mambience.script.Variables;

public abstract class MAPlayer {
	protected UUID playerUUID;
	protected BlockScanner scanner;
	protected Variables variables;
	protected MALogger logger;
	protected MAScriptEngine scriptEngine;
	protected HashMap<String, Integer> cooldowns;
	protected CompiledScript varSetterScript;
	
	public MAPlayer(UUID playerUUID, BlockScanner scanner, Variables variables, MALogger logger) {
		this.playerUUID = playerUUID;
		this.scanner = scanner;
		this.variables = variables;
		this.logger = logger;
		this.scriptEngine = MAScripting.newScriptEngine(logger);
		this.cooldowns = new HashMap<String, Integer>();
	}
	
	public UUID getPlayerUUID() {
		return playerUUID;
	}
	public BlockScanner getScanner() {
		return scanner;
	}
	public Variables getVariables() {
		return variables;
	}
	public MALogger getLogger() {
		return logger;
	}
	public MAScriptEngine getScriptEngine() {
		return scriptEngine;
	}
	
	public int getCooldown(String key) {
		if(!cooldowns.containsKey(key)) return 0;
		
		return cooldowns.get(key);
	}
	public void setCooldown(String key, int value) {
		if(value<0) value = 0;
		
		cooldowns.put(key, value);
	}

	public CompiledScript getVarSetterScript() {
		return varSetterScript;
	}
	public void setVarSetterScript(CompiledScript varSetterScript) {
		this.varSetterScript = varSetterScript;
	}
	
	public abstract void playSound(String sound, float volume, float pitch);
	
	public abstract void stopSound(String sound);
}
