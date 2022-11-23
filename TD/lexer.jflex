package cup.example;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%char
%{
	

    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(is);
        symbolFactory = sf;
    }
	public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
		this(reader);
        symbolFactory = sf;
    }
    
    private StringBuffer sb;
    private ComplexSymbolFactory symbolFactory;
    private int csline,cscolumn;

    public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1, yychar), // -yylength()
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength())
				);
    }
    public Symbol symbol(String name, int code, String lexem){
	return symbolFactory.newSymbol(name, code, 
						new Location(yyline+1, yycolumn +1, yychar), 
						new Location(yyline+1,yycolumn+yylength(), yychar+yylength()), lexem);
    }
    
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+ 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
    
    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" + 
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

Newline    = \r | \n | \r\n
Whitespace = [ \t\f] | {Newline}
Number     = [0-9]+
Digit      = [0-9]
String     = \".*\"
Letter     = [A-Z a-z]

Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = 0[xX][0-9a-fA-F]+
Simple_escape_sequence		=	(\\\'|\\\"|\\\?|\\\\|\\a|\\b|\\f|\\n|\\r|\\t|\\v)
Octal_escape_sequence		=	(\\[0-7]|\\[0-7][0-7]|\\[0-7][0-7][0-7])
Hexadecimal_escape_sequence	=	(\\x{HexInt}+)
Escape_sequence				=	({Simple_escape_sequence}|{Octal_escape_sequence}|{Hexadecimal_escape_sequence})
Universal_character_name	=	(\\u{HexInt}{HexInt}{HexInt}{HexInt}|\\U{HexInt}{HexInt}{HexInt}{HexInt}{HexInt}{HexInt}{HexInt}{HexInt})
Non_digit					=	({Letter}|{Universal_character_name})

Character_lit				=	(L?\'([^\'\\\n]|\\.)*)
Character_literal			=	({Character_lit}\')

String_lit					=	(L?\"([^\"\\\n]|\\.)*)
String_literal				=	({String_lit}\")

PP_number					=	(\.?{Digit}({Digit}|{Non_digit}|[eE][-+]|\.)*)


/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" {CommentContent} \*+ "/"
EndOfLineComment = "//" [^\r\n]* {Newline}
CommentContent = ( [^*] | \*+[^*/] )*

ident = ([:jletter:] | "_" ) ([:jletterdigit:] | [:jletter:] | "_" )*


%eofval{
    return symbolFactory.newSymbol("EOF",sym.EOF);
%eofval}

%state CODESEG

%%  

<YYINITIAL> {

  /* Keywords */
  "class"     { return symbolFactory.newSymbol("CLASS", CLASS); }
  "public"    { return symbolFactory.newSymbol("PUBLIC", PUBLIC); }
  "int"       { return symbolFactory.newSymbol("INT", INT); }
  "float"     { return symbolFactory.newSymbol("FLOAT", FLOAT); }
  "double"    { return symbolFactory.newSymbol("DOUBLE", DOUBLE); }
  "string"    { return symbolFactory.newSymbol("STR", STR); }
  "char"      { return symbolFactory.newSymbol("CHAR", CHAR); }
  "private"   { return symbolFactory.newSymbol("PRIVATE", PRIVATE); }
  "protected" { return symbolFactory.newSymbol("PROTECTED", PROTECTED); }
  "static"    { return symbolFactory.newSymbol("STATIC", STATIC); }
  "namespace" { return symbolFactory.newSymbol("NAMESPACE", NAMESPACE); }
  "define"     { return symbolFactory.newSymbol("DEFINE", DEFINE); } 
  "include"    { return symbolFactory.newSymbol("INCLUDE", INCLUDE); }
  "asm"        { return symbolFactory.newSymbol("ASM", ASM); }
  "auto"       { return symbolFactory.newSymbol("AUTO", AUTO); }
  "break"      { return symbolFactory.newSymbol("BREAK", BREAK); }
  "case"       { return symbolFactory.newSymbol("CASE", CASE); }
  "catch"      { return symbolFactory.newSymbol("CATCH", CATCH); }
  "const"      { return symbolFactory.newSymbol("CONST", CONST); }
  "continue"   { return symbolFactory.newSymbol("CONTINUE", CONTINUE); }
  "default"    { return symbolFactory.newSymbol("DEFAULT", DEFAULT); }
  "delete"     { return symbolFactory.newSymbol("DELETE", DELETE); }
  "do"         { return symbolFactory.newSymbol("DO", DO); }
  "else"       { return symbolFactory.newSymbol("ELSE", ELSE); }
  "enum"       { return symbolFactory.newSymbol("ENUM", ENUM); }
  "extern"     { return symbolFactory.newSymbol("EXTERN", EXTERN); }
  "for"        { return symbolFactory.newSymbol("FOR", FOR); }
  "friend"     { return symbolFactory.newSymbol("FRIEND", FRIEND); }
  "goto"       { return symbolFactory.newSymbol("GOTO", GOTO); }
  "if"         { return symbolFactory.newSymbol("IF", IF); }
  "inline"     { return symbolFactory.newSymbol("INLINE", INLINE); }
  "long"       { return symbolFactory.newSymbol("LONG", LONG); }
  "new"        { return symbolFactory.newSymbol("NEW", NEW); }
  "operator"   { return symbolFactory.newSymbol("OPERATOR", OPERATOR); }
  "register"   { return symbolFactory.newSymbol("REGISTER", REGISTER); }
  "return"     { return symbolFactory.newSymbol("RETURN", RETURN); }
  "short"      { return symbolFactory.newSymbol("SHORT", SHORT); }
  "signed"     { return symbolFactory.newSymbol("SIGNED", SIGNED); }
  "sizeof"     { return symbolFactory.newSymbol("SIZEOF", SIZEOF); }
  "struct"     { return symbolFactory.newSymbol("STRUCT", STRUCT); }
  "switch"     { return symbolFactory.newSymbol("SWITCH", SWITCH); }
  "template"   { return symbolFactory.newSymbol("TEMPLATE", TEMPLATE); }
  "this"       { return symbolFactory.newSymbol("THIS", THIS); }
  "throw"      { return symbolFactory.newSymbol("THROW", THROW); }
  "try"        { return symbolFactory.newSymbol("TRY", TRY); }
  "typedef"    { return symbolFactory.newSymbol("TYPEDEF", TYPEDEF); }
  "union"      { return symbolFactory.newSymbol("UNION", UNION); }
  "unsigned"   { return symbolFactory.newSymbol("UNSIGNED", UNSIGNED); }
  "virtual"    { return symbolFactory.newSymbol("VIRTUAL", VIRTUAL); }
  "void"       { return symbolFactory.newSymbol("VOID", VOID); }
  "volatile"   { return symbolFactory.newSymbol("VOLATILE", VOLATILE); }
  "while"      { return symbolFactory.newSymbol("WHILE", WHILE); }
  "false"      { return symbolFactory.newSymbol("FALSE", FALSE); }
  "true"       { return symbolFactory.newSymbol("TRUE", TRUE); }
  "typeid"	   { return symbolFactory.newSymbol("TYPEID", TYPEID); }
  "typename"   { return symbolFactory.newSymbol("TYPENAME", TYPENAME); }
  "static_cast" { return symbolFactory.newSymbol("STATICCAST", STATICCAST); }
  "dynamic_cast" { return symbolFactory.newSymbol("DYNAMICCAST", DYNAMICCAST); }
  "reinterpret_cast" { return symbolFactory.newSymbol("REINTERPRETCAST", REINTERPRETCAST); }
  "const_cast" { return symbolFactory.newSymbol("CONSTCAST", CONSTCAST); }
  "mutable"    { return symbolFactory.newSymbol("MUTABLE", MUTABLE); }
  "explicit"   { return symbolFactory.newSymbol("EXPLICIT", EXPLICIT); }
  "bool"       { return symbolFactory.newSymbol("BOOLEAN", BOOLEAN); }
  "using"      { return symbolFactory.newSymbol("USING", USING); }
  "export"     { return symbolFactory.newSymbol("EXPORT", EXPORT); }
  
   /* MISC */
  {Number}                      { return symbolFactory.newSymbol("NUMBER", NUMBER, Integer.parseInt(yytext())); }
  {String}                      { return symbolFactory.newSymbol("STRING", STRING); }
  {Whitespace}                  {                              }
  {ident}                       { return symbolFactory.newSymbol("IDENT", IDENT); }
  {Character_lit}				{ return symbolFactory.newSymbol("CHARACTER", CHARACTER, yytext()); } 
  {String_lit}					{ return symbolFactory.newSymbol("STRNG", STRNG, yytext());  }
  {PP_number}					{ return symbolFactory.newSymbol("PPNUMBER", PPNUMBER, Integer.parseInt(yytext())); }
  {Escape_sequence}				|
  {Universal_character_name}	{ return symbolFactory.newSymbol("ESCAPED", ESCAPED); }

   /* Operators */
   
   "::"							{ return symbolFactory.newSymbol("SCOPE", SCOPE); }
   "..."						{ return symbolFactory.newSymbol("ELLIPSIS", ELLIPSIS); }
   "=="							{ return symbolFactory.newSymbol("EQ", EQ); }
   "!="							{ return symbolFactory.newSymbol("NE", NE); }
   "<="							{ return symbolFactory.newSymbol("LE", LE); }
   ">="							{ return symbolFactory.newSymbol("GE", GE); }
   "&&"							{ return symbolFactory.newSymbol("LOG_AND", LOG_AND); }
   "||"							{ return symbolFactory.newSymbol("LOG_OR", LOG_OR); }
   "++"							{ return symbolFactory.newSymbol("INC", INC); }
   "--"							{ return symbolFactory.newSymbol("DEC", DEC); }
   "->*"						{ return symbolFactory.newSymbol("ARROW_STAR", ARROW_STAR); }
   "->"							{ return symbolFactory.newSymbol("ARROW", ARROW); }
   ".*"							{ return symbolFactory.newSymbol("DOT_START", DOT_START); }
   "+="							{ return symbolFactory.newSymbol("ASS_ADD", ASS_ADD); }
   "-="							{ return symbolFactory.newSymbol("ASS_SUB", ASS_SUB); }
   "*="							{ return symbolFactory.newSymbol("ASS_MUL", ASS_MUL); }
   "/="							{ return symbolFactory.newSymbol("ASS_DIV", ASS_DIV); }
   "%="							{ return symbolFactory.newSymbol("ASS_MOD", ASS_MOD); }
   "^="							{ return symbolFactory.newSymbol("ASS_XOR", ASS_XOR); }
   "&="							{ return symbolFactory.newSymbol("ASS_AND", ASS_AND); }
   "|="							{ return symbolFactory.newSymbol("ASS_OR", ASS_OR); }
   ">>="						{ return symbolFactory.newSymbol("ASS_SHR", ASS_SHR); }
   "<<="						{ return symbolFactory.newSymbol("ASS_SHL", ASS_SHL); }
   
   ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
   ":"          { return symbolFactory.newSymbol("COLON", COLON); }
   "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
   "~"			{ return symbolFactory.newSymbol("SQUIGLY", SQUIGLY); }
   "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
   "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
   "n"          { return symbolFactory.newSymbol("UMINUS", UMINUS); }
   "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
   "["			{ return symbolFactory.newSymbol("SQLPAREN", SQLPAREN); }
   "]"			{ return symbolFactory.newSymbol("SQRPAREN", SQRPAREN); }
   ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
   "{"          { return symbolFactory.newSymbol("CLPAREN", CLPAREN); }
   "}"          { return symbolFactory.newSymbol("CRPAREN", CRPAREN); }
   ","          { return symbolFactory.newSymbol("COMMA", COMMA); }
   "<<"         { return symbolFactory.newSymbol("LEFTSHIFT", LEFTSHIFT); }
   ">>"         { return symbolFactory.newSymbol("RIGHTSHIFT", RIGHTSHIFT); }
   "^"          { return symbolFactory.newSymbol("XOR", XOR); }
   "&"          { return symbolFactory.newSymbol("AND", AND); }
   "|"          { return symbolFactory.newSymbol("OR", OR); }
   "<"          { return symbolFactory.newSymbol("SMALLERTHAN", SMALLERTHAN); }
   ">"          { return symbolFactory.newSymbol("GREATERTHAN", GREATERTHAN); }
   "="          { return symbolFactory.newSymbol("EQUAL", EQUAL); }
   "."			{ return symbolFactory.newSymbol("DOT", DOT); }	
   "!"			{ return symbolFactory.newSymbol("ESC", ESC); }
   "%"          { return symbolFactory.newSymbol("PERCENT", PERCENT); }
   "/"          { return symbolFactory.newSymbol("DIVIDE", DIVIDE); }
   "?"          { return symbolFactory.newSymbol("QM", QM); }
   "#"          { return symbolFactory.newSymbol("HASHT", HASHT); }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
