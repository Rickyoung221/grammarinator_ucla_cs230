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
			"'='", null, "'<style>body {margin: 0; font-family: Arial, sans-serif;background-color: #f4f4f4;}</style>'", 
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
		public HtmlBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlBody; }
	}

	public final HtmlBodyContext htmlBody() throws RecognitionException {
		HtmlBodyContext _localctx = new HtmlBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__6);
			setState(52);
			mainWrapper();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPT) {
				{
				setState(53);
				match(SCRIPT);
				}
			}

			setState(56);
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
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
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(T__8);
				setState(59);
				recursiveContent();
				setState(60);
				recursiveContent();
				setState(61);
				recursiveContent();
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
					{
					{
					setState(62);
					recursiveContent();
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SCRIPT) {
					{
					setState(68);
					match(SCRIPT);
					}
				}

				setState(71);
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
				setState(73);
				recursiveContent();
				setState(74);
				recursiveContent();
				setState(75);
				recursiveContent();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
					{
					{
					setState(76);
					recursiveContent();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(82);
					match(SCRIPT);
					}
					break;
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(RANDOM_TEXT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				divWrapper();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				sectionWrapper();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				headerWrapper();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				footerWrapper();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				divWrapper();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				sectionWrapper();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(94);
				headerWrapper();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(95);
				footerWrapper();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(96);
				divWrapper();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(97);
				sectionWrapper();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(98);
				headerWrapper();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(99);
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
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
			setState(102);
			match(T__10);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(103);
				match(INLINE_STYLE);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FLEX_CLASS) {
				{
				setState(106);
				match(FLEX_CLASS);
				}
			}

			setState(109);
			match(CLOSE);
			setState(110);
			recursiveContent();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(111);
				recursiveContent();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPT) {
				{
				setState(117);
				match(SCRIPT);
				}
			}

			setState(120);
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
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
			setState(122);
			match(T__12);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(123);
				match(INLINE_STYLE);
				}
			}

			setState(126);
			match(CLOSE);
			setState(127);
			recursiveContent();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(128);
				recursiveContent();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPT) {
				{
				setState(134);
				match(SCRIPT);
				}
			}

			setState(137);
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
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
			setState(139);
			match(T__14);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(140);
				match(INLINE_STYLE);
				}
			}

			setState(143);
			match(CLOSE);
			setState(144);
			recursiveContent();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(145);
				recursiveContent();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPT) {
				{
				setState(151);
				match(SCRIPT);
				}
			}

			setState(154);
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
		public TerminalNode SCRIPT() { return getToken(htmlParser.SCRIPT, 0); }
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
			setState(156);
			match(T__16);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INLINE_STYLE) {
				{
				setState(157);
				match(INLINE_STYLE);
				}
			}

			setState(160);
			match(CLOSE);
			setState(161);
			recursiveContent();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67282944L) != 0)) {
				{
				{
				setState(162);
				recursiveContent();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCRIPT) {
				{
				setState(168);
				match(SCRIPT);
				}
			}

			setState(171);
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
		"\u0004\u0001*\u00ae\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001\u0002\u0003\u0002"+
		"$\b\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0002\u0003\u0002*\b"+
		"\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u00037\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004@\b\u0004\n\u0004\f\u0004C\t"+
		"\u0004\u0001\u0004\u0003\u0004F\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004N\b\u0004\n\u0004"+
		"\f\u0004Q\t\u0004\u0001\u0004\u0003\u0004T\b\u0004\u0003\u0004V\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005e\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006"+
		"i\b\u0006\u0001\u0006\u0003\u0006l\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006q\b\u0006\n\u0006\f\u0006t\t\u0006\u0001\u0006\u0003"+
		"\u0006w\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007}\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0082"+
		"\b\u0007\n\u0007\f\u0007\u0085\t\u0007\u0001\u0007\u0003\u0007\u0088\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\b\u008e\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u0093\b\b\n\b\f\b\u0096\t\b\u0001\b\u0003\b"+
		"\u0099\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u009f\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00a4\b\t\n\t\f\t\u00a7\t\t\u0001\t\u0003\t\u00aa\b"+
		"\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0000\u0000\u00c8\u0000\u0014\u0001\u0000\u0000\u0000"+
		"\u0002\u001a\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000"+
		"\u00063\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nd\u0001\u0000"+
		"\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000ez\u0001\u0000\u0000\u0000"+
		"\u0010\u008b\u0001\u0000\u0000\u0000\u0012\u009c\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0005\u0001\u0000\u0000\u0015\u0016\u0003\u0002\u0001\u0000"+
		"\u0016\u0017\u0005\u0002\u0000\u0000\u0017\u0018\u0005\u0000\u0000\u0001"+
		"\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001b\u0003\u0004\u0002\u0000"+
		"\u001a\u0019\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0006\u0003\u0000"+
		"\u001d\u0003\u0001\u0000\u0000\u0000\u001e \u0005\u0003\u0000\u0000\u001f"+
		"!\u0005\u0019\u0000\u0000 \u001f\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!#\u0001\u0000\u0000\u0000\"$\u0005\u001e\u0000\u0000#\"\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000"+
		"%\'\u0005\u001e\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\')\u0001\u0000\u0000\u0000(*\u0005\u001e\u0000\u0000)(\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+-\u0005"+
		"\u001e\u0000\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0005\u001a\u0000"+
		"\u000001\u0005\u0005\u0000\u000012\u0005\u0006\u0000\u00002\u0005\u0001"+
		"\u0000\u0000\u000034\u0005\u0007\u0000\u000046\u0003\b\u0004\u000057\u0005"+
		"\u0018\u0000\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0005\b\u0000\u00009\u0007\u0001\u0000\u0000"+
		"\u0000:;\u0005\t\u0000\u0000;<\u0003\n\u0005\u0000<=\u0003\n\u0005\u0000"+
		"=A\u0003\n\u0005\u0000>@\u0003\n\u0005\u0000?>\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DF\u0005\u0018"+
		"\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GH\u0005\n\u0000\u0000HV\u0001\u0000\u0000\u0000IJ\u0003"+
		"\n\u0005\u0000JK\u0003\n\u0005\u0000KO\u0003\n\u0005\u0000LN\u0003\n\u0005"+
		"\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RT\u0005\u0018\u0000\u0000SR\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000U:\u0001\u0000\u0000"+
		"\u0000UI\u0001\u0000\u0000\u0000V\t\u0001\u0000\u0000\u0000We\u0005\u001a"+
		"\u0000\u0000Xe\u0003\f\u0006\u0000Ye\u0003\u000e\u0007\u0000Ze\u0003\u0010"+
		"\b\u0000[e\u0003\u0012\t\u0000\\e\u0003\f\u0006\u0000]e\u0003\u000e\u0007"+
		"\u0000^e\u0003\u0010\b\u0000_e\u0003\u0012\t\u0000`e\u0003\f\u0006\u0000"+
		"ae\u0003\u000e\u0007\u0000be\u0003\u0010\b\u0000ce\u0003\u0012\t\u0000"+
		"dW\u0001\u0000\u0000\u0000dX\u0001\u0000\u0000\u0000dY\u0001\u0000\u0000"+
		"\u0000dZ\u0001\u0000\u0000\u0000d[\u0001\u0000\u0000\u0000d\\\u0001\u0000"+
		"\u0000\u0000d]\u0001\u0000\u0000\u0000d^\u0001\u0000\u0000\u0000d_\u0001"+
		"\u0000\u0000\u0000d`\u0001\u0000\u0000\u0000da\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000e\u000b\u0001\u0000"+
		"\u0000\u0000fh\u0005\u000b\u0000\u0000gi\u0005\u001f\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jl\u0005\u001d\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u0014\u0000\u0000nr\u0003\n\u0005"+
		"\u0000oq\u0003\n\u0005\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sv\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uw\u0005\u0018\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xy\u0005\f\u0000\u0000y\r\u0001\u0000\u0000\u0000z|\u0005\r\u0000\u0000"+
		"{}\u0005\u001f\u0000\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0005\u0014\u0000\u0000\u007f"+
		"\u0083\u0003\n\u0005\u0000\u0080\u0082\u0003\n\u0005\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0087"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0005\u0018\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u000e\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000\u008b\u008d"+
		"\u0005\u000f\u0000\u0000\u008c\u008e\u0005\u001f\u0000\u0000\u008d\u008c"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0014\u0000\u0000\u0090\u0094"+
		"\u0003\n\u0005\u0000\u0091\u0093\u0003\n\u0005\u0000\u0092\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0098\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0099\u0005"+
		"\u0018\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005"+
		"\u0010\u0000\u0000\u009b\u0011\u0001\u0000\u0000\u0000\u009c\u009e\u0005"+
		"\u0011\u0000\u0000\u009d\u009f\u0005\u001f\u0000\u0000\u009e\u009d\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0005\u0014\u0000\u0000\u00a1\u00a5\u0003"+
		"\n\u0005\u0000\u00a2\u00a4\u0003\n\u0005\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00aa\u0005\u0018"+
		"\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0012"+
		"\u0000\u0000\u00ac\u0013\u0001\u0000\u0000\u0000\u001a\u001a #&),6AEO"+
		"SUdhkrv|\u0083\u0087\u008d\u0094\u0098\u009e\u00a5\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}