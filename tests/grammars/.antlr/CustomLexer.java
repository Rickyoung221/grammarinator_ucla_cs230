// Generated from /Users/wangjiacheng/Documents/2024FALL/230/grammarinator_ucla_cs230/tests/grammars/Custom.g4 by ANTLR 4.13.1

from copy import deepcopy
from sys import platform as CustomLexerPlatform

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CustomLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, XML=4, ID=5, CONTENT=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "XML", "ID", "CONTENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'</'", "'<?xml>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "XML", "ID", "CONTENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	def _custom_lexer_content(self):
	    return CustomLexerPlatform


	public CustomLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Custom.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 5:
			CONTENT_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void CONTENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			current.src += self._custom_lexer_content()
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0006/\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0004\u0004\u001d\b\u0004\u000b\u0004\f\u0004\u001e\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0000\u0000\u0006\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\u0001\u0000\u0001\u0001\u0000az/\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0001\r"+
		"\u0001\u0000\u0000\u0000\u0003\u000f\u0001\u0000\u0000\u0000\u0005\u0011"+
		"\u0001\u0000\u0000\u0000\u0007\u0014\u0001\u0000\u0000\u0000\t\u001c\u0001"+
		"\u0000\u0000\u0000\u000b \u0001\u0000\u0000\u0000\r\u000e\u0005<\u0000"+
		"\u0000\u000e\u0002\u0001\u0000\u0000\u0000\u000f\u0010\u0005>\u0000\u0000"+
		"\u0010\u0004\u0001\u0000\u0000\u0000\u0011\u0012\u0005<\u0000\u0000\u0012"+
		"\u0013\u0005/\u0000\u0000\u0013\u0006\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0005<\u0000\u0000\u0015\u0016\u0005?\u0000\u0000\u0016\u0017\u0005x"+
		"\u0000\u0000\u0017\u0018\u0005m\u0000\u0000\u0018\u0019\u0005l\u0000\u0000"+
		"\u0019\u001a\u0005>\u0000\u0000\u001a\b\u0001\u0000\u0000\u0000\u001b"+
		"\u001d\u0007\u0000\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0001\u0000\u0000\u0000\u001f\n\u0001\u0000\u0000\u0000 !\u0005"+
		"<\u0000\u0000!\"\u0005!\u0000\u0000\"#\u0005[\u0000\u0000#$\u0005C\u0000"+
		"\u0000$%\u0005D\u0000\u0000%&\u0005A\u0000\u0000&\'\u0005T\u0000\u0000"+
		"\'(\u0005A\u0000\u0000()\u0005[\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*+\u0006\u0005\u0000\u0000+,\u0005]\u0000\u0000,-\u0005]\u0000\u0000-"+
		".\u0005>\u0000\u0000.\f\u0001\u0000\u0000\u0000\u0002\u0000\u001e\u0001"+
		"\u0001\u0005\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}