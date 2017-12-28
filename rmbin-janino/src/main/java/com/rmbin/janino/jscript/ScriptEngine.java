package com.rmbin.janino.jscript;

import java.io.File;
import java.io.IOException;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ScriptEvaluator;

public class ScriptEngine {
	
		public ScriptEngine engine;
		
		private ScriptEngine(){}
		
		static class EngineHolder
		{
			 static final ScriptEngine holder = new ScriptEngine();
		}
		
		public ScriptEngine getInstance()
		{
			return EngineHolder.holder;
		}
		
		public void caculate(File file) throws CompileException, IOException
		{
			ScriptEvaluator evaluator = new ScriptEvaluator();
			evaluator.cookFile(file);
		}

		public void caculate(String txt) throws CompileException
		{
			ScriptEvaluator evaluator = new ScriptEvaluator();
			evaluator.cook(txt);
		}
}
