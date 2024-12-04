// Generated from g:/Work/grammarinator_ucla_cs230/target/html.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class htmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, OPEN=19, CLOSE=20, OPEN_SLASH=21, SLASH_CLOSE=22, EQUALS=23, 
		SCRIPT=24, GLOBAL_STYLE=25, RANDOM_TEXT=26, PX=27, DIM=28, FLEX_CLASS=29, 
		META=30, INLINE_STYLE=31, WIDTH_STYLE=32, HEIGHT_STYLE=33, COLOR=34, COLOR_STYLE=35, 
		POSITION=36, POS_DISTANCE_TYPE=37, POS_DISTANCE=38, POSITION_STYLE=39, 
		BORDER_TYPE=40, BORDER_RADIUS=41, BORDDER_STYLE=42;
	public static final int
		RULE_html = 0, RULE_main = 1, RULE_htmlHead = 2, RULE_htmlBody = 3, RULE_mainWrapper = 4, 
		RULE_recursiveContent = 5, RULE_divWrapper = 6, RULE_sectionWrapper = 7, 
		RULE_headerWrapper = 8, RULE_footerWrapper = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"html", "main", "htmlHead", "htmlBody", "mainWrapper", "recursiveContent", 
			"divWrapper", "sectionWrapper", "headerWrapper", "footerWrapper"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<!DOCTYPE html> <html lang=\"en\">'", "'</html>'", "'<head>'", 
			"'<title>'", "'</title>'", "'</head>'", "'<body>'", "'</body>'", "'<main>'", 
			"'</main>'", "'<div '", "'</div>'", "'<section '", "'</section>'", "'<header '", 
			"'</header>'", "'<footer '", "'</footer>'", "'<'", "'>'", "'</'", "'/>'", 
			"'='", "'<script>console.log(\"Inline script executed\");</script>'", 
			"'<style>body {margin: 0; font-family: Arial, sans-serif;background-color: #f4f4f4;}</style>'", 
			null, null, null, "'class=\"flex-container\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "OPEN", "CLOSE", "OPEN_SLASH", 
			"SLASH_CLOSE", "EQUALS", "SCRIPT", "GLOBAL_STYLE", "RANDOM_TEXT", "PX", 
			"DIM", "FLEX_CLASS", "META", "INLINE_STYLE", "WIDTH_STYLE", "HEIGHT_STYLE", 
			"COLOR", "COLOR_STYLE", "POSITION", "POS_DISTANCE_TYPE", "POS_DISTANCE", 
			"POSITION_STYLE", "BORDER_TYPE", "BORDER_RADIUS", "BORDDER_STYLE"
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

	@Override
	public String getGrammarFileName() { return "html.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public htmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(htmlParser.EOF, 0); }
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_html);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(T__0);
			setState(21);
			main();
			setState(22);
			match(T__1);
			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public HtmlBodyContext htmlBody() {
			return getRuleContext(HtmlBodyContext.class,0);
		}
		public HtmlHeadContext htmlHead() {
			return getRuleContext(HtmlHeadContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(25);
				htmlHead();
				}
			}

			setState(28);
			htmlBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlHeadContext extends ParserRuleContext {
		public TerminalNode RANDOM_TEXT() { return getToken(htmlParser.RANDOM_TEXT, 0); }
		public TerminalNode GLOBAL_STYLE() { return getToken(htmlParser.GLOBAL_STYLE, 0); }
		public List<TerminalNode> META() { return getTokens(htmlParser.META); }
		public TerminalNode META(int i) {
			return getToken(htmlParser.META, i);
		}
		public HtmlHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlHead; }
	}

	public final HtmlHeadContext htmlHead() throws RecognitionException {
		HtmlHeadContext _localctx = new HtmlHeadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__2);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GLOBAL_STYLE) {
				{
				setState(31);
				match(GLOBAL_STYLE);
				}
			}

			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(34);
				match(META);
				}
				break;
			}
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(37);
				match(META);
				}
				break;
			}
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(40);
				match(META);
				}
				break;
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==META) {
				{
				setState(43);
				match(META);
				}
			}

			setState(46);
			match(T__3);
			setState(47);
			match(RANDOM_TEXT);
			setState(48);
			match(T__4);
			setState(49);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlBodyContext extends ParserRuleContext {
		public MainWrapperContext mainWrapper() {
			return getRuleContext(MainWrapperContext.class,0);
		}
		public HtmlBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlBody; }
	}

	public final HtmlBodyContext htmlBody() throws RecognitionException {
		HtmlBodyContext _localctx = new HtmlBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__6);
			setState(52);
			mainWrapper();
			setState(53);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainWrapperContext extends ParserRuleContext {
		public List<RecursiveContentContext> recursiveContent() {
			return getRuleContexts(RecursiveContentContext.class);
		}
		public RecursiveContentContext recursiveContent(int i) {
			return getRuleContext(RecursiveContentContext.class,i);
		}
		public MainWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainWrapper; }
	}

	public final MainWrapperContext mainWrapper() throws RecognitionException {
		MainWrapperContext _localctx = new MainWrapperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mainWrapper);
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__8);
				setState(56);
				recursiveContent();
				setState(57);
				recursiveContent();
				setState(58);
				recursiveContent();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
					{
					{
					setState(59);
					recursiveContent();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(T__9);
				}
				break;
			case T__10:
			case T__12:
			case T__14:
			case T__16:
			case RANDOM_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				recursiveContent();
				setState(68);
				recursiveContent();
				setState(69);
				recursiveContent();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
					{
					{
					setState(70);
					recursiveContent();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RecursiveContentContext extends ParserRuleContext {
		public TerminalNode RANDOM_TEXT() { return getToken(htmlParser.RANDOM_TEXT, 0); }
		public DivWrapperContext divWrapper() {
			return getRuleContext(DivWrapperContext.class,0);
		}
		public SectionWrapperContext sectionWrapper() {
			return getRuleContext(SectionWrapperContext.class,0);
		}
		public HeaderWrapperContext headerWrapper() {
			return getRuleContext(HeaderWrapperContext.class,0);
		}
		public FooterWrapperContext footerWrapper() {
			return getRuleContext(FooterWrapperContext.class,0);
		}
		public RecursiveContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recursiveContent; }
	}

	public final RecursiveContentContext recursiveContent() throws RecognitionException {
		RecursiveContentContext _localctx = new RecursiveContentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_recursiveContent);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(RANDOM_TEXT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				divWrapper();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				sectionWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				headerWrapper();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				footerWrapper();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				divWrapper();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				sectionWrapper();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(85);
				headerWrapper();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(86);
				footerWrapper();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(87);
				divWrapper();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(88);
				sectionWrapper();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(89);
				headerWrapper();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(90);
				footerWrapper();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DivWrapperContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(htmlParser.CLOSE, 0); }
		public List<RecursiveContentContext> recursiveContent() {
			return getRuleContexts(RecursiveContentContext.class);
		}
		public RecursiveContentContext recursiveContent(int i) {
			return getRuleContext(RecursiveContentContext.class,i);
		}
		public TerminalNode INLINE_STYLE() { return getToken(htmlParser.INLINE_STYLE, 0); }
		public TerminalNode FLEX_CLASS() { return getToken(htmlParser.FLEX_CLASS, 0); }
		public DivWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divWrapper; }
	}

	public final DivWrapperContext divWrapper() throws RecognitionException {
		DivWrapperContext _localctx = new DivWrapperContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_divWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__10);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(94);
				match(INLINE_STYLE);
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLEX_CLASS) {
				{
				setState(97);
				match(FLEX_CLASS);
				}
			}

			setState(100);
			match(CLOSE);
			setState(101);
			recursiveContent();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(102);
				recursiveContent();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SectionWrapperContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(htmlParser.CLOSE, 0); }
		public List<RecursiveContentContext> recursiveContent() {
			return getRuleContexts(RecursiveContentContext.class);
		}
		public RecursiveContentContext recursiveContent(int i) {
			return getRuleContext(RecursiveContentContext.class,i);
		}
		public TerminalNode INLINE_STYLE() { return getToken(htmlParser.INLINE_STYLE, 0); }
		public SectionWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionWrapper; }
	}

	public final SectionWrapperContext sectionWrapper() throws RecognitionException {
		SectionWrapperContext _localctx = new SectionWrapperContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sectionWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__12);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(111);
				match(INLINE_STYLE);
				}
			}

			setState(114);
			match(CLOSE);
			setState(115);
			recursiveContent();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(116);
				recursiveContent();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderWrapperContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(htmlParser.CLOSE, 0); }
		public List<RecursiveContentContext> recursiveContent() {
			return getRuleContexts(RecursiveContentContext.class);
		}
		public RecursiveContentContext recursiveContent(int i) {
			return getRuleContext(RecursiveContentContext.class,i);
		}
		public TerminalNode INLINE_STYLE() { return getToken(htmlParser.INLINE_STYLE, 0); }
		public HeaderWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerWrapper; }
	}

	public final HeaderWrapperContext headerWrapper() throws RecognitionException {
		HeaderWrapperContext _localctx = new HeaderWrapperContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_headerWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__14);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(125);
				match(INLINE_STYLE);
				}
			}

			setState(128);
			match(CLOSE);
			setState(129);
			recursiveContent();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(130);
				recursiveContent();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FooterWrapperContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(htmlParser.CLOSE, 0); }
		public List<RecursiveContentContext> recursiveContent() {
			return getRuleContexts(RecursiveContentContext.class);
		}
		public RecursiveContentContext recursiveContent(int i) {
			return getRuleContext(RecursiveContentContext.class,i);
		}
		public TerminalNode INLINE_STYLE() { return getToken(htmlParser.INLINE_STYLE, 0); }
		public FooterWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_footerWrapper; }
	}

	public final FooterWrapperContext footerWrapper() throws RecognitionException {
		FooterWrapperContext _localctx = new FooterWrapperContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_footerWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__16);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(139);
				match(INLINE_STYLE);
				}
			}

			setState(142);
			match(CLOSE);
			setState(143);
			recursiveContent();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(144);
				recursiveContent();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0099\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001\u0002\u0003\u0002"+
		"$\b\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0002\u0003\u0002*\b"+
		"\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004=\b\u0004\n\u0004\f\u0004@\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004"+
		"\f\u0004K\t\u0004\u0003\u0004M\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\\\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0003\u0006`\b\u0006\u0001\u0006\u0003\u0006"+
		"c\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006h\b\u0006\n\u0006"+
		"\f\u0006k\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007q\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007v\b\u0007"+
		"\n\u0007\f\u0007y\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003"+
		"\b\u007f\b\b\u0001\b\u0001\b\u0001\b\u0005\b\u0084\b\b\n\b\f\b\u0087\t"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u008d\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0092\b\t\n\t\f\t\u0095\t\t\u0001\t\u0001\t\u0001\t\u0000\u0000"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0000\u00ac\u0000"+
		"\u0014\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u0004"+
		"\u001e\u0001\u0000\u0000\u0000\u00063\u0001\u0000\u0000\u0000\bL\u0001"+
		"\u0000\u0000\u0000\n[\u0001\u0000\u0000\u0000\f]\u0001\u0000\u0000\u0000"+
		"\u000en\u0001\u0000\u0000\u0000\u0010|\u0001\u0000\u0000\u0000\u0012\u008a"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0005\u0001\u0000\u0000\u0015\u0016"+
		"\u0003\u0002\u0001\u0000\u0016\u0017\u0005\u0002\u0000\u0000\u0017\u0018"+
		"\u0005\u0000\u0000\u0001\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001b"+
		"\u0003\u0004\u0002\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001a\u001b"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0003\u0006\u0003\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e \u0005"+
		"\u0003\u0000\u0000\u001f!\u0005\u0019\u0000\u0000 \u001f\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000\u0000\u0000\"$\u0005\u001e"+
		"\u0000\u0000#\"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001"+
		"\u0000\u0000\u0000%\'\u0005\u001e\u0000\u0000&%\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(*\u0005\u001e\u0000"+
		"\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000"+
		"\u0000\u0000+-\u0005\u001e\u0000\u0000,+\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0005\u0004\u0000\u0000"+
		"/0\u0005\u001a\u0000\u000001\u0005\u0005\u0000\u000012\u0005\u0006\u0000"+
		"\u00002\u0005\u0001\u0000\u0000\u000034\u0005\u0007\u0000\u000045\u0003"+
		"\b\u0004\u000056\u0005\b\u0000\u00006\u0007\u0001\u0000\u0000\u000078"+
		"\u0005\t\u0000\u000089\u0003\n\u0005\u00009:\u0003\n\u0005\u0000:>\u0003"+
		"\n\u0005\u0000;=\u0003\n\u0005\u0000<;\u0001\u0000\u0000\u0000=@\u0001"+
		"\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0005\n\u0000\u0000"+
		"BM\u0001\u0000\u0000\u0000CD\u0003\n\u0005\u0000DE\u0003\n\u0005\u0000"+
		"EI\u0003\n\u0005\u0000FH\u0003\n\u0005\u0000GF\u0001\u0000\u0000\u0000"+
		"HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000L7\u0001\u0000"+
		"\u0000\u0000LC\u0001\u0000\u0000\u0000M\t\u0001\u0000\u0000\u0000N\\\u0005"+
		"\u001a\u0000\u0000O\\\u0003\f\u0006\u0000P\\\u0003\u000e\u0007\u0000Q"+
		"\\\u0003\u0010\b\u0000R\\\u0003\u0012\t\u0000S\\\u0003\f\u0006\u0000T"+
		"\\\u0003\u000e\u0007\u0000U\\\u0003\u0010\b\u0000V\\\u0003\u0012\t\u0000"+
		"W\\\u0003\f\u0006\u0000X\\\u0003\u000e\u0007\u0000Y\\\u0003\u0010\b\u0000"+
		"Z\\\u0003\u0012\t\u0000[N\u0001\u0000\u0000\u0000[O\u0001\u0000\u0000"+
		"\u0000[P\u0001\u0000\u0000\u0000[Q\u0001\u0000\u0000\u0000[R\u0001\u0000"+
		"\u0000\u0000[S\u0001\u0000\u0000\u0000[T\u0001\u0000\u0000\u0000[U\u0001"+
		"\u0000\u0000\u0000[V\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000\u0000"+
		"[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000"+
		"\u0000\\\u000b\u0001\u0000\u0000\u0000]_\u0005\u000b\u0000\u0000^`\u0005"+
		"\u001f\u0000\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`b\u0001\u0000\u0000\u0000ac\u0005\u001d\u0000\u0000ba\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0005\u0014"+
		"\u0000\u0000ei\u0003\n\u0005\u0000fh\u0003\n\u0005\u0000gf\u0001\u0000"+
		"\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000"+
		"lm\u0005\f\u0000\u0000m\r\u0001\u0000\u0000\u0000np\u0005\r\u0000\u0000"+
		"oq\u0005\u001f\u0000\u0000po\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rs\u0005\u0014\u0000\u0000sw\u0003\n\u0005"+
		"\u0000tv\u0003\n\u0005\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005\u000e\u0000\u0000{\u000f"+
		"\u0001\u0000\u0000\u0000|~\u0005\u000f\u0000\u0000}\u007f\u0005\u001f"+
		"\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0014\u0000\u0000"+
		"\u0081\u0085\u0003\n\u0005\u0000\u0082\u0084\u0003\n\u0005\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0005\u0010\u0000\u0000\u0089\u0011\u0001\u0000\u0000\u0000\u008a"+
		"\u008c\u0005\u0011\u0000\u0000\u008b\u008d\u0005\u001f\u0000\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0014\u0000\u0000\u008f"+
		"\u0093\u0003\n\u0005\u0000\u0090\u0092\u0003\n\u0005\u0000\u0091\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005\u0012\u0000\u0000\u0097\u0013\u0001\u0000\u0000\u0000\u0013\u001a"+
		" #&),>IL[_bipw~\u0085\u008c\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}