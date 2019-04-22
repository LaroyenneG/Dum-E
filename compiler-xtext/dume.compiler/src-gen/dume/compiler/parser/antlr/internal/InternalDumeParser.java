package dume.compiler.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import dume.compiler.services.DumeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDumeParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Script'", "'{'", "'}'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'('", "')'", "'on'", "'shape'", "'drawing'", "'clear'", "'go'", "'circle'", "'center'", "'radius'", "'loop'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalDumeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDumeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDumeParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDume.g"; }



     	private DumeGrammarAccess grammarAccess;

        public InternalDumeParser(TokenStream input, DumeGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Scripts";
       	}

       	@Override
       	protected DumeGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleScripts"
    // InternalDume.g:64:1: entryRuleScripts returns [EObject current=null] : iv_ruleScripts= ruleScripts EOF ;
    public final EObject entryRuleScripts() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScripts = null;


        try {
            // InternalDume.g:64:48: (iv_ruleScripts= ruleScripts EOF )
            // InternalDume.g:65:2: iv_ruleScripts= ruleScripts EOF
            {
             newCompositeNode(grammarAccess.getScriptsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScripts=ruleScripts();

            state._fsp--;

             current =iv_ruleScripts; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScripts"


    // $ANTLR start "ruleScripts"
    // InternalDume.g:71:1: ruleScripts returns [EObject current=null] : ( (lv_script_0_0= ruleScript ) )* ;
    public final EObject ruleScripts() throws RecognitionException {
        EObject current = null;

        EObject lv_script_0_0 = null;



        	enterRule();

        try {
            // InternalDume.g:77:2: ( ( (lv_script_0_0= ruleScript ) )* )
            // InternalDume.g:78:2: ( (lv_script_0_0= ruleScript ) )*
            {
            // InternalDume.g:78:2: ( (lv_script_0_0= ruleScript ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDume.g:79:3: (lv_script_0_0= ruleScript )
            	    {
            	    // InternalDume.g:79:3: (lv_script_0_0= ruleScript )
            	    // InternalDume.g:80:4: lv_script_0_0= ruleScript
            	    {

            	    				newCompositeNode(grammarAccess.getScriptsAccess().getScriptScriptParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_script_0_0=ruleScript();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getScriptsRule());
            	    				}
            	    				add(
            	    					current,
            	    					"script",
            	    					lv_script_0_0,
            	    					"dume.compiler.Dume.Script");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScripts"


    // $ANTLR start "entryRuleScript"
    // InternalDume.g:100:1: entryRuleScript returns [EObject current=null] : iv_ruleScript= ruleScript EOF ;
    public final EObject entryRuleScript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScript = null;


        try {
            // InternalDume.g:100:47: (iv_ruleScript= ruleScript EOF )
            // InternalDume.g:101:2: iv_ruleScript= ruleScript EOF
            {
             newCompositeNode(grammarAccess.getScriptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScript=ruleScript();

            state._fsp--;

             current =iv_ruleScript; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScript"


    // $ANTLR start "ruleScript"
    // InternalDume.g:107:1: ruleScript returns [EObject current=null] : (otherlv_0= 'Script' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) ;
    public final EObject ruleScript() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_instructions_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:113:2: ( (otherlv_0= 'Script' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) )
            // InternalDume.g:114:2: (otherlv_0= 'Script' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            {
            // InternalDume.g:114:2: (otherlv_0= 'Script' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            // InternalDume.g:115:3: otherlv_0= 'Script' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getScriptAccess().getScriptKeyword_0());
            		
            // InternalDume.g:119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDume.g:120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDume.g:120:4: (lv_name_1_0= RULE_ID )
            // InternalDume.g:121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScriptAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScriptRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getScriptAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:141:3: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=24 && LA2_0<=26)||LA2_0==30) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalDume.g:142:4: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // InternalDume.g:142:4: (lv_instructions_3_0= ruleInstruction )
            	    // InternalDume.g:143:5: lv_instructions_3_0= ruleInstruction
            	    {

            	    					newCompositeNode(grammarAccess.getScriptAccess().getInstructionsInstructionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScriptRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instructions",
            	    						lv_instructions_3_0,
            	    						"dume.compiler.Dume.Instruction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getScriptAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScript"


    // $ANTLR start "entryRuleInstruction"
    // InternalDume.g:168:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalDume.g:168:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalDume.g:169:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalDume.g:175:1: ruleInstruction returns [EObject current=null] : (this_Drawing_0= ruleDrawing | this_Clear_1= ruleClear | this_Go_2= ruleGo | this_Loop_3= ruleLoop ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Drawing_0 = null;

        EObject this_Clear_1 = null;

        EObject this_Go_2 = null;

        EObject this_Loop_3 = null;



        	enterRule();

        try {
            // InternalDume.g:181:2: ( (this_Drawing_0= ruleDrawing | this_Clear_1= ruleClear | this_Go_2= ruleGo | this_Loop_3= ruleLoop ) )
            // InternalDume.g:182:2: (this_Drawing_0= ruleDrawing | this_Clear_1= ruleClear | this_Go_2= ruleGo | this_Loop_3= ruleLoop )
            {
            // InternalDume.g:182:2: (this_Drawing_0= ruleDrawing | this_Clear_1= ruleClear | this_Go_2= ruleGo | this_Loop_3= ruleLoop )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt3=1;
                }
                break;
            case 25:
                {
                alt3=2;
                }
                break;
            case 26:
                {
                alt3=3;
                }
                break;
            case 30:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalDume.g:183:3: this_Drawing_0= ruleDrawing
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getDrawingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Drawing_0=ruleDrawing();

                    state._fsp--;


                    			current = this_Drawing_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:192:3: this_Clear_1= ruleClear
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getClearParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Clear_1=ruleClear();

                    state._fsp--;


                    			current = this_Clear_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDume.g:201:3: this_Go_2= ruleGo
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getGoParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Go_2=ruleGo();

                    state._fsp--;


                    			current = this_Go_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDume.g:210:3: this_Loop_3= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getLoopParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_3=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleMap"
    // InternalDume.g:222:1: entryRuleMap returns [String current=null] : iv_ruleMap= ruleMap EOF ;
    public final String entryRuleMap() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMap = null;


        try {
            // InternalDume.g:222:43: (iv_ruleMap= ruleMap EOF )
            // InternalDume.g:223:2: iv_ruleMap= ruleMap EOF
            {
             newCompositeNode(grammarAccess.getMapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMap=ruleMap();

            state._fsp--;

             current =iv_ruleMap.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMap"


    // $ANTLR start "ruleMap"
    // InternalDume.g:229:1: ruleMap returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' ) ;
    public final AntlrDatatypeRuleToken ruleMap() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDume.g:235:2: ( (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' ) )
            // InternalDume.g:236:2: (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' )
            {
            // InternalDume.g:236:2: (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 17:
                {
                alt4=4;
                }
                break;
            case 18:
                {
                alt4=5;
                }
                break;
            case 19:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDume.g:237:3: kw= 'A'
                    {
                    kw=(Token)match(input,14,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getAKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:243:3: kw= 'B'
                    {
                    kw=(Token)match(input,15,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getBKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDume.g:249:3: kw= 'C'
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getCKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDume.g:255:3: kw= 'D'
                    {
                    kw=(Token)match(input,17,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDume.g:261:3: kw= 'E'
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getEKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalDume.g:267:3: kw= 'F'
                    {
                    kw=(Token)match(input,19,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getFKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRulePoint3D"
    // InternalDume.g:276:1: entryRulePoint3D returns [EObject current=null] : iv_rulePoint3D= rulePoint3D EOF ;
    public final EObject entryRulePoint3D() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint3D = null;


        try {
            // InternalDume.g:276:48: (iv_rulePoint3D= rulePoint3D EOF )
            // InternalDume.g:277:2: iv_rulePoint3D= rulePoint3D EOF
            {
             newCompositeNode(grammarAccess.getPoint3DRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint3D=rulePoint3D();

            state._fsp--;

             current =iv_rulePoint3D; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint3D"


    // $ANTLR start "rulePoint3D"
    // InternalDume.g:283:1: rulePoint3D returns [EObject current=null] : (otherlv_0= '(' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_z_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject rulePoint3D() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_x_1_0=null;
        Token lv_y_2_0=null;
        Token lv_z_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalDume.g:289:2: ( (otherlv_0= '(' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_z_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalDume.g:290:2: (otherlv_0= '(' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_z_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalDume.g:290:2: (otherlv_0= '(' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_z_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalDume.g:291:3: otherlv_0= '(' ( (lv_x_1_0= RULE_INT ) ) ( (lv_y_2_0= RULE_INT ) ) ( (lv_z_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPoint3DAccess().getLeftParenthesisKeyword_0());
            		
            // InternalDume.g:295:3: ( (lv_x_1_0= RULE_INT ) )
            // InternalDume.g:296:4: (lv_x_1_0= RULE_INT )
            {
            // InternalDume.g:296:4: (lv_x_1_0= RULE_INT )
            // InternalDume.g:297:5: lv_x_1_0= RULE_INT
            {
            lv_x_1_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_x_1_0, grammarAccess.getPoint3DAccess().getXINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoint3DRule());
            					}
            					setWithLastConsumed(
            						current,
            						"x",
            						lv_x_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalDume.g:313:3: ( (lv_y_2_0= RULE_INT ) )
            // InternalDume.g:314:4: (lv_y_2_0= RULE_INT )
            {
            // InternalDume.g:314:4: (lv_y_2_0= RULE_INT )
            // InternalDume.g:315:5: lv_y_2_0= RULE_INT
            {
            lv_y_2_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_y_2_0, grammarAccess.getPoint3DAccess().getYINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoint3DRule());
            					}
            					setWithLastConsumed(
            						current,
            						"y",
            						lv_y_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalDume.g:331:3: ( (lv_z_3_0= RULE_INT ) )
            // InternalDume.g:332:4: (lv_z_3_0= RULE_INT )
            {
            // InternalDume.g:332:4: (lv_z_3_0= RULE_INT )
            // InternalDume.g:333:5: lv_z_3_0= RULE_INT
            {
            lv_z_3_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_z_3_0, grammarAccess.getPoint3DAccess().getZINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoint3DRule());
            					}
            					setWithLastConsumed(
            						current,
            						"z",
            						lv_z_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPoint3DAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint3D"


    // $ANTLR start "entryRulePoint2D"
    // InternalDume.g:357:1: entryRulePoint2D returns [EObject current=null] : iv_rulePoint2D= rulePoint2D EOF ;
    public final EObject entryRulePoint2D() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint2D = null;


        try {
            // InternalDume.g:357:48: (iv_rulePoint2D= rulePoint2D EOF )
            // InternalDume.g:358:2: iv_rulePoint2D= rulePoint2D EOF
            {
             newCompositeNode(grammarAccess.getPoint2DRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint2D=rulePoint2D();

            state._fsp--;

             current =iv_rulePoint2D; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint2D"


    // $ANTLR start "rulePoint2D"
    // InternalDume.g:364:1: rulePoint2D returns [EObject current=null] : (otherlv_0= '(' ( (lv_i_1_0= RULE_INT ) ) ( (lv_j_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final EObject rulePoint2D() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_i_1_0=null;
        Token lv_j_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalDume.g:370:2: ( (otherlv_0= '(' ( (lv_i_1_0= RULE_INT ) ) ( (lv_j_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // InternalDume.g:371:2: (otherlv_0= '(' ( (lv_i_1_0= RULE_INT ) ) ( (lv_j_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // InternalDume.g:371:2: (otherlv_0= '(' ( (lv_i_1_0= RULE_INT ) ) ( (lv_j_2_0= RULE_INT ) ) otherlv_3= ')' )
            // InternalDume.g:372:3: otherlv_0= '(' ( (lv_i_1_0= RULE_INT ) ) ( (lv_j_2_0= RULE_INT ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getPoint2DAccess().getLeftParenthesisKeyword_0());
            		
            // InternalDume.g:376:3: ( (lv_i_1_0= RULE_INT ) )
            // InternalDume.g:377:4: (lv_i_1_0= RULE_INT )
            {
            // InternalDume.g:377:4: (lv_i_1_0= RULE_INT )
            // InternalDume.g:378:5: lv_i_1_0= RULE_INT
            {
            lv_i_1_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_i_1_0, grammarAccess.getPoint2DAccess().getIINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoint2DRule());
            					}
            					setWithLastConsumed(
            						current,
            						"i",
            						lv_i_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalDume.g:394:3: ( (lv_j_2_0= RULE_INT ) )
            // InternalDume.g:395:4: (lv_j_2_0= RULE_INT )
            {
            // InternalDume.g:395:4: (lv_j_2_0= RULE_INT )
            // InternalDume.g:396:5: lv_j_2_0= RULE_INT
            {
            lv_j_2_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_j_2_0, grammarAccess.getPoint2DAccess().getJINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPoint2DRule());
            					}
            					setWithLastConsumed(
            						current,
            						"j",
            						lv_j_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPoint2DAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint2D"


    // $ANTLR start "entryRulePoint"
    // InternalDume.g:420:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalDume.g:420:46: (iv_rulePoint= rulePoint EOF )
            // InternalDume.g:421:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalDume.g:427:1: rulePoint returns [EObject current=null] : (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Point3D_0 = null;

        EObject this_Point2D_1 = null;

        AntlrDatatypeRuleToken lv_map_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:433:2: ( (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) ) )
            // InternalDume.g:434:2: (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) )
            {
            // InternalDume.g:434:2: (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_INT) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_INT) ) {
                        int LA5_3 = input.LA(4);

                        if ( (LA5_3==RULE_INT) ) {
                            alt5=1;
                        }
                        else if ( (LA5_3==21) ) {
                            alt5=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalDume.g:435:3: this_Point3D_0= rulePoint3D
                    {

                    			newCompositeNode(grammarAccess.getPointAccess().getPoint3DParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Point3D_0=rulePoint3D();

                    state._fsp--;


                    			current = this_Point3D_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:444:3: (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) )
                    {
                    // InternalDume.g:444:3: (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) )
                    // InternalDume.g:445:4: this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) )
                    {

                    				newCompositeNode(grammarAccess.getPointAccess().getPoint2DParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_Point2D_1=rulePoint2D();

                    state._fsp--;


                    				current = this_Point2D_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,22,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getPointAccess().getOnKeyword_1_1());
                    			
                    // InternalDume.g:457:4: ( (lv_map_3_0= ruleMap ) )
                    // InternalDume.g:458:5: (lv_map_3_0= ruleMap )
                    {
                    // InternalDume.g:458:5: (lv_map_3_0= ruleMap )
                    // InternalDume.g:459:6: lv_map_3_0= ruleMap
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getMapMapParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_map_3_0=ruleMap();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"map",
                    							lv_map_3_0,
                    							"dume.compiler.Dume.Map");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRuleShape"
    // InternalDume.g:481:1: entryRuleShape returns [EObject current=null] : iv_ruleShape= ruleShape EOF ;
    public final EObject entryRuleShape() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape = null;


        try {
            // InternalDume.g:481:46: (iv_ruleShape= ruleShape EOF )
            // InternalDume.g:482:2: iv_ruleShape= ruleShape EOF
            {
             newCompositeNode(grammarAccess.getShapeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShape=ruleShape();

            state._fsp--;

             current =iv_ruleShape; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShape"


    // $ANTLR start "ruleShape"
    // InternalDume.g:488:1: ruleShape returns [EObject current=null] : (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle ) ;
    public final EObject ruleShape() throws RecognitionException {
        EObject current = null;

        EObject this_Shape2D_0 = null;

        EObject this_Shape3D_1 = null;

        EObject this_Circle_2 = null;



        	enterRule();

        try {
            // InternalDume.g:494:2: ( (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle ) )
            // InternalDume.g:495:2: (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle )
            {
            // InternalDume.g:495:2: (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    alt6=1;
                }
                else if ( (LA6_1==12) ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==27) ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalDume.g:496:3: this_Shape2D_0= ruleShape2D
                    {

                    			newCompositeNode(grammarAccess.getShapeAccess().getShape2DParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Shape2D_0=ruleShape2D();

                    state._fsp--;


                    			current = this_Shape2D_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:505:3: this_Shape3D_1= ruleShape3D
                    {

                    			newCompositeNode(grammarAccess.getShapeAccess().getShape3DParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Shape3D_1=ruleShape3D();

                    state._fsp--;


                    			current = this_Shape3D_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDume.g:514:3: this_Circle_2= ruleCircle
                    {

                    			newCompositeNode(grammarAccess.getShapeAccess().getCircleParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Circle_2=ruleCircle();

                    state._fsp--;


                    			current = this_Circle_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShape"


    // $ANTLR start "entryRuleShape3D"
    // InternalDume.g:526:1: entryRuleShape3D returns [EObject current=null] : iv_ruleShape3D= ruleShape3D EOF ;
    public final EObject entryRuleShape3D() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape3D = null;


        try {
            // InternalDume.g:526:48: (iv_ruleShape3D= ruleShape3D EOF )
            // InternalDume.g:527:2: iv_ruleShape3D= ruleShape3D EOF
            {
             newCompositeNode(grammarAccess.getShape3DRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShape3D=ruleShape3D();

            state._fsp--;

             current =iv_ruleShape3D; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShape3D"


    // $ANTLR start "ruleShape3D"
    // InternalDume.g:533:1: ruleShape3D returns [EObject current=null] : ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' ) ;
    public final EObject ruleShape3D() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_points_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:539:2: ( ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' ) )
            // InternalDume.g:540:2: ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' )
            {
            // InternalDume.g:540:2: ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' )
            // InternalDume.g:541:3: () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}'
            {
            // InternalDume.g:541:3: ()
            // InternalDume.g:542:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape3DAccess().getShape3DAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getShape3DAccess().getShapeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getShape3DAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:556:3: ( (lv_points_3_0= rulePoint3D ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDume.g:557:4: (lv_points_3_0= rulePoint3D )
            	    {
            	    // InternalDume.g:557:4: (lv_points_3_0= rulePoint3D )
            	    // InternalDume.g:558:5: lv_points_3_0= rulePoint3D
            	    {

            	    					newCompositeNode(grammarAccess.getShape3DAccess().getPointsPoint3DParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_points_3_0=rulePoint3D();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getShape3DRule());
            	    					}
            	    					add(
            	    						current,
            	    						"points",
            	    						lv_points_3_0,
            	    						"dume.compiler.Dume.Point3D");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getShape3DAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShape3D"


    // $ANTLR start "entryRuleShape2D"
    // InternalDume.g:583:1: entryRuleShape2D returns [EObject current=null] : iv_ruleShape2D= ruleShape2D EOF ;
    public final EObject entryRuleShape2D() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape2D = null;


        try {
            // InternalDume.g:583:48: (iv_ruleShape2D= ruleShape2D EOF )
            // InternalDume.g:584:2: iv_ruleShape2D= ruleShape2D EOF
            {
             newCompositeNode(grammarAccess.getShape2DRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShape2D=ruleShape2D();

            state._fsp--;

             current =iv_ruleShape2D; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShape2D"


    // $ANTLR start "ruleShape2D"
    // InternalDume.g:590:1: ruleShape2D returns [EObject current=null] : ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' ) ;
    public final EObject ruleShape2D() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_map_3_0 = null;

        EObject lv_points_5_0 = null;



        	enterRule();

        try {
            // InternalDume.g:596:2: ( ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' ) )
            // InternalDume.g:597:2: ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' )
            {
            // InternalDume.g:597:2: ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' )
            // InternalDume.g:598:3: () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}'
            {
            // InternalDume.g:598:3: ()
            // InternalDume.g:599:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape2DAccess().getShape2DAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getShape2DAccess().getShapeKeyword_1());
            		
            otherlv_2=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getShape2DAccess().getOnKeyword_2());
            		
            // InternalDume.g:613:3: ( (lv_map_3_0= ruleMap ) )
            // InternalDume.g:614:4: (lv_map_3_0= ruleMap )
            {
            // InternalDume.g:614:4: (lv_map_3_0= ruleMap )
            // InternalDume.g:615:5: lv_map_3_0= ruleMap
            {

            					newCompositeNode(grammarAccess.getShape2DAccess().getMapMapParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_5);
            lv_map_3_0=ruleMap();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getShape2DRule());
            					}
            					set(
            						current,
            						"map",
            						lv_map_3_0,
            						"dume.compiler.Dume.Map");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getShape2DAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalDume.g:636:3: ( (lv_points_5_0= rulePoint2D ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==20) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDume.g:637:4: (lv_points_5_0= rulePoint2D )
            	    {
            	    // InternalDume.g:637:4: (lv_points_5_0= rulePoint2D )
            	    // InternalDume.g:638:5: lv_points_5_0= rulePoint2D
            	    {

            	    					newCompositeNode(grammarAccess.getShape2DAccess().getPointsPoint2DParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_points_5_0=rulePoint2D();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getShape2DRule());
            	    					}
            	    					add(
            	    						current,
            	    						"points",
            	    						lv_points_5_0,
            	    						"dume.compiler.Dume.Point2D");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getShape2DAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShape2D"


    // $ANTLR start "entryRuleDrawing"
    // InternalDume.g:663:1: entryRuleDrawing returns [EObject current=null] : iv_ruleDrawing= ruleDrawing EOF ;
    public final EObject entryRuleDrawing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDrawing = null;


        try {
            // InternalDume.g:663:48: (iv_ruleDrawing= ruleDrawing EOF )
            // InternalDume.g:664:2: iv_ruleDrawing= ruleDrawing EOF
            {
             newCompositeNode(grammarAccess.getDrawingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDrawing=ruleDrawing();

            state._fsp--;

             current =iv_ruleDrawing; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDrawing"


    // $ANTLR start "ruleDrawing"
    // InternalDume.g:670:1: ruleDrawing returns [EObject current=null] : ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' ) ;
    public final EObject ruleDrawing() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_shapes_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:676:2: ( ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' ) )
            // InternalDume.g:677:2: ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' )
            {
            // InternalDume.g:677:2: ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' )
            // InternalDume.g:678:3: () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}'
            {
            // InternalDume.g:678:3: ()
            // InternalDume.g:679:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDrawingAccess().getDrawingAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getDrawingAccess().getDrawingKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getDrawingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:693:3: ( (lv_shapes_3_0= ruleShape ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23||LA9_0==27) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDume.g:694:4: (lv_shapes_3_0= ruleShape )
            	    {
            	    // InternalDume.g:694:4: (lv_shapes_3_0= ruleShape )
            	    // InternalDume.g:695:5: lv_shapes_3_0= ruleShape
            	    {

            	    					newCompositeNode(grammarAccess.getDrawingAccess().getShapesShapeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_shapes_3_0=ruleShape();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDrawingRule());
            	    					}
            	    					add(
            	    						current,
            	    						"shapes",
            	    						lv_shapes_3_0,
            	    						"dume.compiler.Dume.Shape");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDrawingAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDrawing"


    // $ANTLR start "entryRuleClear"
    // InternalDume.g:720:1: entryRuleClear returns [EObject current=null] : iv_ruleClear= ruleClear EOF ;
    public final EObject entryRuleClear() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClear = null;


        try {
            // InternalDume.g:720:46: (iv_ruleClear= ruleClear EOF )
            // InternalDume.g:721:2: iv_ruleClear= ruleClear EOF
            {
             newCompositeNode(grammarAccess.getClearRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClear=ruleClear();

            state._fsp--;

             current =iv_ruleClear; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClear"


    // $ANTLR start "ruleClear"
    // InternalDume.g:727:1: ruleClear returns [EObject current=null] : ( () otherlv_1= 'clear' ) ;
    public final EObject ruleClear() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDume.g:733:2: ( ( () otherlv_1= 'clear' ) )
            // InternalDume.g:734:2: ( () otherlv_1= 'clear' )
            {
            // InternalDume.g:734:2: ( () otherlv_1= 'clear' )
            // InternalDume.g:735:3: () otherlv_1= 'clear'
            {
            // InternalDume.g:735:3: ()
            // InternalDume.g:736:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClearAccess().getClearAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getClearAccess().getClearKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClear"


    // $ANTLR start "entryRuleGo"
    // InternalDume.g:750:1: entryRuleGo returns [EObject current=null] : iv_ruleGo= ruleGo EOF ;
    public final EObject entryRuleGo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGo = null;


        try {
            // InternalDume.g:750:43: (iv_ruleGo= ruleGo EOF )
            // InternalDume.g:751:2: iv_ruleGo= ruleGo EOF
            {
             newCompositeNode(grammarAccess.getGoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGo=ruleGo();

            state._fsp--;

             current =iv_ruleGo; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGo"


    // $ANTLR start "ruleGo"
    // InternalDume.g:757:1: ruleGo returns [EObject current=null] : (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) ) ;
    public final EObject ruleGo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_point_1_0 = null;



        	enterRule();

        try {
            // InternalDume.g:763:2: ( (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) ) )
            // InternalDume.g:764:2: (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) )
            {
            // InternalDume.g:764:2: (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) )
            // InternalDume.g:765:3: otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getGoAccess().getGoKeyword_0());
            		
            // InternalDume.g:769:3: ( (lv_point_1_0= rulePoint ) )
            // InternalDume.g:770:4: (lv_point_1_0= rulePoint )
            {
            // InternalDume.g:770:4: (lv_point_1_0= rulePoint )
            // InternalDume.g:771:5: lv_point_1_0= rulePoint
            {

            					newCompositeNode(grammarAccess.getGoAccess().getPointPointParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_point_1_0=rulePoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGoRule());
            					}
            					set(
            						current,
            						"point",
            						lv_point_1_0,
            						"dume.compiler.Dume.Point");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGo"


    // $ANTLR start "entryRuleCircle"
    // InternalDume.g:792:1: entryRuleCircle returns [EObject current=null] : iv_ruleCircle= ruleCircle EOF ;
    public final EObject entryRuleCircle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCircle = null;


        try {
            // InternalDume.g:792:47: (iv_ruleCircle= ruleCircle EOF )
            // InternalDume.g:793:2: iv_ruleCircle= ruleCircle EOF
            {
             newCompositeNode(grammarAccess.getCircleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCircle=ruleCircle();

            state._fsp--;

             current =iv_ruleCircle; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCircle"


    // $ANTLR start "ruleCircle"
    // InternalDume.g:799:1: ruleCircle returns [EObject current=null] : (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) ) ;
    public final EObject ruleCircle() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_radius_4_0=null;
        Token otherlv_5=null;
        EObject lv_point_2_0 = null;

        AntlrDatatypeRuleToken lv_map_6_0 = null;



        	enterRule();

        try {
            // InternalDume.g:805:2: ( (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) ) )
            // InternalDume.g:806:2: (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) )
            {
            // InternalDume.g:806:2: (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) )
            // InternalDume.g:807:3: otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getCircleAccess().getCircleKeyword_0());
            		
            otherlv_1=(Token)match(input,28,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getCircleAccess().getCenterKeyword_1());
            		
            // InternalDume.g:815:3: ( (lv_point_2_0= rulePoint2D ) )
            // InternalDume.g:816:4: (lv_point_2_0= rulePoint2D )
            {
            // InternalDume.g:816:4: (lv_point_2_0= rulePoint2D )
            // InternalDume.g:817:5: lv_point_2_0= rulePoint2D
            {

            					newCompositeNode(grammarAccess.getCircleAccess().getPointPoint2DParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_point_2_0=rulePoint2D();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCircleRule());
            					}
            					set(
            						current,
            						"point",
            						lv_point_2_0,
            						"dume.compiler.Dume.Point2D");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getCircleAccess().getRadiusKeyword_3());
            		
            // InternalDume.g:838:3: ( (lv_radius_4_0= RULE_INT ) )
            // InternalDume.g:839:4: (lv_radius_4_0= RULE_INT )
            {
            // InternalDume.g:839:4: (lv_radius_4_0= RULE_INT )
            // InternalDume.g:840:5: lv_radius_4_0= RULE_INT
            {
            lv_radius_4_0=(Token)match(input,RULE_INT,FOLLOW_9); 

            					newLeafNode(lv_radius_4_0, grammarAccess.getCircleAccess().getRadiusINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCircleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"radius",
            						lv_radius_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getCircleAccess().getOnKeyword_5());
            		
            // InternalDume.g:860:3: ( (lv_map_6_0= ruleMap ) )
            // InternalDume.g:861:4: (lv_map_6_0= ruleMap )
            {
            // InternalDume.g:861:4: (lv_map_6_0= ruleMap )
            // InternalDume.g:862:5: lv_map_6_0= ruleMap
            {

            					newCompositeNode(grammarAccess.getCircleAccess().getMapMapParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_map_6_0=ruleMap();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCircleRule());
            					}
            					set(
            						current,
            						"map",
            						lv_map_6_0,
            						"dume.compiler.Dume.Map");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCircle"


    // $ANTLR start "entryRuleLoop"
    // InternalDume.g:883:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalDume.g:883:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalDume.g:884:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalDume.g:890:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_n_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_instructions_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:896:2: ( (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) )
            // InternalDume.g:897:2: (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            {
            // InternalDume.g:897:2: (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            // InternalDume.g:898:3: otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
            		
            // InternalDume.g:902:3: ( (lv_n_1_0= RULE_INT ) )
            // InternalDume.g:903:4: (lv_n_1_0= RULE_INT )
            {
            // InternalDume.g:903:4: (lv_n_1_0= RULE_INT )
            // InternalDume.g:904:5: lv_n_1_0= RULE_INT
            {
            lv_n_1_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_n_1_0, grammarAccess.getLoopAccess().getNINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"n",
            						lv_n_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:924:3: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=24 && LA10_0<=26)||LA10_0==30) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDume.g:925:4: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // InternalDume.g:925:4: (lv_instructions_3_0= ruleInstruction )
            	    // InternalDume.g:926:5: lv_instructions_3_0= ruleInstruction
            	    {

            	    					newCompositeNode(grammarAccess.getLoopAccess().getInstructionsInstructionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLoopRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instructions",
            	    						lv_instructions_3_0,
            	    						"dume.compiler.Dume.Instruction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000047002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000FC000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008802000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});

}