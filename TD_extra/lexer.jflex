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
String     = [A-Za-z]*

Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = 0[xX][0-9a-fA-F]+

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

  {Whitespace} {                              }
  ";"          { return symbolFactory.newSymbol("SEMI", SEMI); }
  "+"          { return symbolFactory.newSymbol("PLUS", PLUS); }
  "-"          { return symbolFactory.newSymbol("MINUS", MINUS); }
  "*"          { return symbolFactory.newSymbol("TIMES", TIMES); }
  "n"          { return symbolFactory.newSymbol("UMINUS", UMINUS); }
  "("          { return symbolFactory.newSymbol("LPAREN", LPAREN); }
  ")"          { return symbolFactory.newSymbol("RPAREN", RPAREN); }
  "{"          { return symbolFactory.newSymbol("CLPAREN", CLPAREN); }
  "}"          { return symbolFactory.newSymbol("CRPAREN", CRPAREN); }
  ","          { return symbolFactory.newSymbol("COMMA", COMMA); }
  {Number}     { return symbolFactory.newSymbol("NUMBER", NUMBER, Integer.parseInt(yytext())); }
  {String}     { return symbolFactory.newSymbol("STRING", STRING, yytext()); }
  "class "     { return symbolFactory.newSymbol("CLASS", CLASS); }
  "public:"    { return symbolFactory.newSymbol("PUBLIC", PUBLIC); }
  "int "       { return symbolFactory.newSymbol("INT", INT); }
  "float "     { return symbolFactory.newSymbol("FLOAT", FLOAT); }
  "double "    { return symbolFactory.newSymbol("DOUBLE", DOUBLE); }
  "string "    { return symbolFactory.newSymbol("STR", STR); }
  "char "      { return symbolFactory.newSymbol("CR", CR); }
  "private:"   { return symbolFactory.newSymbol("PRIVATE", PRIVATE); }
  "protected:" { return symbolFactory.newSymbol("PROTECTED", PROTECTED); }
  "static "    { return symbolFactory.newSymbol("ST", ST); }
  "namespace " { return symbolFactory.newSymbol("NAMESPACE", NAMESPACE); }
  "define "     { return symbolFactory.newSymbol("DEFINE", DEFINE); } 
  "include "    { return symbolFactory.newSymbol("INCLUDE", INCLUDE); }
  "asm "        { return symbolFactory.newSymbol("ASM", ASM); }
  "auto "       { return symbolFactory.newSymbol("AUTO", AUTO); }
  "break "      { return symbolFactory.newSymbol("BREAK", BREAK); }
  "case "       { return symbolFactory.newSymbol("CASE", CASE); }
  "catch "      { return symbolFactory.newSymbol("CATCH", CATCH); }
  "const "      { return symbolFactory.newSymbol("CONST", CONST); }
  "continue "   { return symbolFactory.newSymbol("CONTINUE", CONTINUE); }
  "default "    { return symbolFactory.newSymbol("DEFAULT", DEFAULT); }
  "delete "     { return symbolFactory.newSymbol("DELETE", DELETE); }
  "do "         { return symbolFactory.newSymbol("DO", DO); }
  "else "       { return symbolFactory.newSymbol("ELSE", ELSE); }
  "enum "       { return symbolFactory.newSymbol("ENUM", ENUM); }
  "extern "     { return symbolFactory.newSymbol("EXTERN", EXTERN); }
  "for "        { return symbolFactory.newSymbol("FOR", FOR); }
  "friend "     { return symbolFactory.newSymbol("FRIEND", FRIEND); }
  "goto "       { return symbolFactory.newSymbol("GOTO", GOTO); }
  "if "         { return symbolFactory.newSymbol("IF", IF); }
  "inline "     { return symbolFactory.newSymbol("INLINE", INLINE); }
  "long "       { return symbolFactory.newSymbol("LONG", LONG); }
  "new "        { return symbolFactory.newSymbol("NEW", NEW); }
  "operator "   { return symbolFactory.newSymbol("OPERATOR", OPERATOR); }
  "register "   { return symbolFactory.newSymbol("REGISTER", REGISTER); }
  "return "     { return symbolFactory.newSymbol("RETURN", RETURN); }
  "short "      { return symbolFactory.newSymbol("SHORT", SHORT); }
  "signed "     { return symbolFactory.newSymbol("SIGNED", SIGNED); }
  "sizeof "     { return symbolFactory.newSymbol("SIZEOF", SIZEOF); }
  "struct "     { return symbolFactory.newSymbol("STRUCT", STRUCT); }
  "switch "     { return symbolFactory.newSymbol("SWITCH", SWITCH); }
  "template "   { return symbolFactory.newSymbol("TEMPLATE", TEMPLATE); }
  "this "       { return symbolFactory.newSymbol("THIS", THIS); }
  "throw "      { return symbolFactory.newSymbol("THROW", THROW); }
  "try "        { return symbolFactory.newSymbol("TRY", TRY); }
  "typedef "    { return symbolFactory.newSymbol("TYPEDEF", TYPEDEF); }
  "union "      { return symbolFactory.newSymbol("UNION", UNION); }
  "unsigned "   { return symbolFactory.newSymbol("UNSIGNED", UNSIGNED); }
  "virtual "    { return symbolFactory.newSymbol("VIRTUAL", VIRTUAL); }
  "void "       { return symbolFactory.newSymbol("VOID", VOID); }
  "volatile "   { return symbolFactory.newSymbol("VOLATILE", VOLATILE); }
  "while "      { return symbolFactory.newSymbol("WHILE", WHILE); }
  "<< "         { return symbolFactory.newSymbol("LEFTSHIFT", LEFTSHIFT); }
  ">> "         { return symbolFactory.newSymbol("RIGHTSHIFT", RIGHTSHIFT); }
  "^ "          { return symbolFactory.newSymbol("XOR", XOR); }
  "& "          { return symbolFactory.newSymbol("AND", AND); }
  "| "          { return symbolFactory.newSymbol("OR", OR); }
  "< "          { return symbolFactory.newSymbol("SMALLERTHAN", SMALLERTHAN); }
  "> "          { return symbolFactory.newSymbol("GREATERTHAN", GREATERTHAN); }
}



// error fallback
.|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
