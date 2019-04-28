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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Script'", "'{'", "'}'", "'-'", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'on'", "'shape'", "'drawing'", "'go'", "'circle'", "'center'", "'radius'", "'loop'"
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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

                if ( ((LA2_0>=23 && LA2_0<=24)||LA2_0==28) ) {
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


    // $ANTLR start "entryRuleNumber"
    // InternalDume.g:168:1: entryRuleNumber returns [EObject current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final EObject entryRuleNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumber = null;


        try {
            // InternalDume.g:168:47: (iv_ruleNumber= ruleNumber EOF )
            // InternalDume.g:169:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber; 
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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalDume.g:175:1: ruleNumber returns [EObject current=null] : (this_Negative_0= ruleNegative | this_Positive_1= rulePositive ) ;
    public final EObject ruleNumber() throws RecognitionException {
        EObject current = null;

        EObject this_Negative_0 = null;

        EObject this_Positive_1 = null;



        	enterRule();

        try {
            // InternalDume.g:181:2: ( (this_Negative_0= ruleNegative | this_Positive_1= rulePositive ) )
            // InternalDume.g:182:2: (this_Negative_0= ruleNegative | this_Positive_1= rulePositive )
            {
            // InternalDume.g:182:2: (this_Negative_0= ruleNegative | this_Positive_1= rulePositive )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDume.g:183:3: this_Negative_0= ruleNegative
                    {

                    			newCompositeNode(grammarAccess.getNumberAccess().getNegativeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Negative_0=ruleNegative();

                    state._fsp--;


                    			current = this_Negative_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:192:3: this_Positive_1= rulePositive
                    {

                    			newCompositeNode(grammarAccess.getNumberAccess().getPositiveParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Positive_1=rulePositive();

                    state._fsp--;


                    			current = this_Positive_1;
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
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleNegative"
    // InternalDume.g:204:1: entryRuleNegative returns [EObject current=null] : iv_ruleNegative= ruleNegative EOF ;
    public final EObject entryRuleNegative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegative = null;


        try {
            // InternalDume.g:204:49: (iv_ruleNegative= ruleNegative EOF )
            // InternalDume.g:205:2: iv_ruleNegative= ruleNegative EOF
            {
             newCompositeNode(grammarAccess.getNegativeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegative=ruleNegative();

            state._fsp--;

             current =iv_ruleNegative; 
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
    // $ANTLR end "entryRuleNegative"


    // $ANTLR start "ruleNegative"
    // InternalDume.g:211:1: ruleNegative returns [EObject current=null] : (otherlv_0= '-' ( (lv_v_1_0= RULE_INT ) ) ) ;
    public final EObject ruleNegative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_v_1_0=null;


        	enterRule();

        try {
            // InternalDume.g:217:2: ( (otherlv_0= '-' ( (lv_v_1_0= RULE_INT ) ) ) )
            // InternalDume.g:218:2: (otherlv_0= '-' ( (lv_v_1_0= RULE_INT ) ) )
            {
            // InternalDume.g:218:2: (otherlv_0= '-' ( (lv_v_1_0= RULE_INT ) ) )
            // InternalDume.g:219:3: otherlv_0= '-' ( (lv_v_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getNegativeAccess().getHyphenMinusKeyword_0());
            		
            // InternalDume.g:223:3: ( (lv_v_1_0= RULE_INT ) )
            // InternalDume.g:224:4: (lv_v_1_0= RULE_INT )
            {
            // InternalDume.g:224:4: (lv_v_1_0= RULE_INT )
            // InternalDume.g:225:5: lv_v_1_0= RULE_INT
            {
            lv_v_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_v_1_0, grammarAccess.getNegativeAccess().getVINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNegativeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"v",
            						lv_v_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleNegative"


    // $ANTLR start "entryRulePositive"
    // InternalDume.g:245:1: entryRulePositive returns [EObject current=null] : iv_rulePositive= rulePositive EOF ;
    public final EObject entryRulePositive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePositive = null;


        try {
            // InternalDume.g:245:49: (iv_rulePositive= rulePositive EOF )
            // InternalDume.g:246:2: iv_rulePositive= rulePositive EOF
            {
             newCompositeNode(grammarAccess.getPositiveRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePositive=rulePositive();

            state._fsp--;

             current =iv_rulePositive; 
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
    // $ANTLR end "entryRulePositive"


    // $ANTLR start "rulePositive"
    // InternalDume.g:252:1: rulePositive returns [EObject current=null] : ( (lv_v_0_0= RULE_INT ) ) ;
    public final EObject rulePositive() throws RecognitionException {
        EObject current = null;

        Token lv_v_0_0=null;


        	enterRule();

        try {
            // InternalDume.g:258:2: ( ( (lv_v_0_0= RULE_INT ) ) )
            // InternalDume.g:259:2: ( (lv_v_0_0= RULE_INT ) )
            {
            // InternalDume.g:259:2: ( (lv_v_0_0= RULE_INT ) )
            // InternalDume.g:260:3: (lv_v_0_0= RULE_INT )
            {
            // InternalDume.g:260:3: (lv_v_0_0= RULE_INT )
            // InternalDume.g:261:4: lv_v_0_0= RULE_INT
            {
            lv_v_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_v_0_0, grammarAccess.getPositiveAccess().getVINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPositiveRule());
            				}
            				setWithLastConsumed(
            					current,
            					"v",
            					lv_v_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "rulePositive"


    // $ANTLR start "entryRuleInstruction"
    // InternalDume.g:280:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalDume.g:280:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalDume.g:281:2: iv_ruleInstruction= ruleInstruction EOF
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
    // InternalDume.g:287:1: ruleInstruction returns [EObject current=null] : (this_Drawing_0= ruleDrawing | this_Go_1= ruleGo | this_Loop_2= ruleLoop ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Drawing_0 = null;

        EObject this_Go_1 = null;

        EObject this_Loop_2 = null;



        	enterRule();

        try {
            // InternalDume.g:293:2: ( (this_Drawing_0= ruleDrawing | this_Go_1= ruleGo | this_Loop_2= ruleLoop ) )
            // InternalDume.g:294:2: (this_Drawing_0= ruleDrawing | this_Go_1= ruleGo | this_Loop_2= ruleLoop )
            {
            // InternalDume.g:294:2: (this_Drawing_0= ruleDrawing | this_Go_1= ruleGo | this_Loop_2= ruleLoop )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt4=1;
                }
                break;
            case 24:
                {
                alt4=2;
                }
                break;
            case 28:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDume.g:295:3: this_Drawing_0= ruleDrawing
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
                    // InternalDume.g:304:3: this_Go_1= ruleGo
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getGoParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Go_1=ruleGo();

                    state._fsp--;


                    			current = this_Go_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDume.g:313:3: this_Loop_2= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getLoopParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_2=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_2;
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
    // InternalDume.g:325:1: entryRuleMap returns [String current=null] : iv_ruleMap= ruleMap EOF ;
    public final String entryRuleMap() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMap = null;


        try {
            // InternalDume.g:325:43: (iv_ruleMap= ruleMap EOF )
            // InternalDume.g:326:2: iv_ruleMap= ruleMap EOF
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
    // InternalDume.g:332:1: ruleMap returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' ) ;
    public final AntlrDatatypeRuleToken ruleMap() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDume.g:338:2: ( (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' ) )
            // InternalDume.g:339:2: (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' )
            {
            // InternalDume.g:339:2: (kw= 'A' | kw= 'B' | kw= 'C' | kw= 'D' | kw= 'E' | kw= 'F' )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 16:
                {
                alt5=2;
                }
                break;
            case 17:
                {
                alt5=3;
                }
                break;
            case 18:
                {
                alt5=4;
                }
                break;
            case 19:
                {
                alt5=5;
                }
                break;
            case 20:
                {
                alt5=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDume.g:340:3: kw= 'A'
                    {
                    kw=(Token)match(input,15,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getAKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDume.g:346:3: kw= 'B'
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getBKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDume.g:352:3: kw= 'C'
                    {
                    kw=(Token)match(input,17,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getCKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDume.g:358:3: kw= 'D'
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDume.g:364:3: kw= 'E'
                    {
                    kw=(Token)match(input,19,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getMapAccess().getEKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalDume.g:370:3: kw= 'F'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

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
    // InternalDume.g:379:1: entryRulePoint3D returns [EObject current=null] : iv_rulePoint3D= rulePoint3D EOF ;
    public final EObject entryRulePoint3D() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint3D = null;


        try {
            // InternalDume.g:379:48: (iv_rulePoint3D= rulePoint3D EOF )
            // InternalDume.g:380:2: iv_rulePoint3D= rulePoint3D EOF
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
    // InternalDume.g:386:1: rulePoint3D returns [EObject current=null] : ( ( (lv_x_0_0= ruleNumber ) ) ( (lv_y_1_0= ruleNumber ) ) ( (lv_z_2_0= ruleNumber ) ) ) ;
    public final EObject rulePoint3D() throws RecognitionException {
        EObject current = null;

        EObject lv_x_0_0 = null;

        EObject lv_y_1_0 = null;

        EObject lv_z_2_0 = null;



        	enterRule();

        try {
            // InternalDume.g:392:2: ( ( ( (lv_x_0_0= ruleNumber ) ) ( (lv_y_1_0= ruleNumber ) ) ( (lv_z_2_0= ruleNumber ) ) ) )
            // InternalDume.g:393:2: ( ( (lv_x_0_0= ruleNumber ) ) ( (lv_y_1_0= ruleNumber ) ) ( (lv_z_2_0= ruleNumber ) ) )
            {
            // InternalDume.g:393:2: ( ( (lv_x_0_0= ruleNumber ) ) ( (lv_y_1_0= ruleNumber ) ) ( (lv_z_2_0= ruleNumber ) ) )
            // InternalDume.g:394:3: ( (lv_x_0_0= ruleNumber ) ) ( (lv_y_1_0= ruleNumber ) ) ( (lv_z_2_0= ruleNumber ) )
            {
            // InternalDume.g:394:3: ( (lv_x_0_0= ruleNumber ) )
            // InternalDume.g:395:4: (lv_x_0_0= ruleNumber )
            {
            // InternalDume.g:395:4: (lv_x_0_0= ruleNumber )
            // InternalDume.g:396:5: lv_x_0_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPoint3DAccess().getXNumberParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_x_0_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoint3DRule());
            					}
            					set(
            						current,
            						"x",
            						lv_x_0_0,
            						"dume.compiler.Dume.Number");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDume.g:413:3: ( (lv_y_1_0= ruleNumber ) )
            // InternalDume.g:414:4: (lv_y_1_0= ruleNumber )
            {
            // InternalDume.g:414:4: (lv_y_1_0= ruleNumber )
            // InternalDume.g:415:5: lv_y_1_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPoint3DAccess().getYNumberParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_y_1_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoint3DRule());
            					}
            					set(
            						current,
            						"y",
            						lv_y_1_0,
            						"dume.compiler.Dume.Number");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDume.g:432:3: ( (lv_z_2_0= ruleNumber ) )
            // InternalDume.g:433:4: (lv_z_2_0= ruleNumber )
            {
            // InternalDume.g:433:4: (lv_z_2_0= ruleNumber )
            // InternalDume.g:434:5: lv_z_2_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPoint3DAccess().getZNumberParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_z_2_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoint3DRule());
            					}
            					set(
            						current,
            						"z",
            						lv_z_2_0,
            						"dume.compiler.Dume.Number");
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
    // $ANTLR end "rulePoint3D"


    // $ANTLR start "entryRulePoint2D"
    // InternalDume.g:455:1: entryRulePoint2D returns [EObject current=null] : iv_rulePoint2D= rulePoint2D EOF ;
    public final EObject entryRulePoint2D() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint2D = null;


        try {
            // InternalDume.g:455:48: (iv_rulePoint2D= rulePoint2D EOF )
            // InternalDume.g:456:2: iv_rulePoint2D= rulePoint2D EOF
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
    // InternalDume.g:462:1: rulePoint2D returns [EObject current=null] : ( ( (lv_i_0_0= ruleNumber ) ) ( (lv_j_1_0= ruleNumber ) ) ) ;
    public final EObject rulePoint2D() throws RecognitionException {
        EObject current = null;

        EObject lv_i_0_0 = null;

        EObject lv_j_1_0 = null;



        	enterRule();

        try {
            // InternalDume.g:468:2: ( ( ( (lv_i_0_0= ruleNumber ) ) ( (lv_j_1_0= ruleNumber ) ) ) )
            // InternalDume.g:469:2: ( ( (lv_i_0_0= ruleNumber ) ) ( (lv_j_1_0= ruleNumber ) ) )
            {
            // InternalDume.g:469:2: ( ( (lv_i_0_0= ruleNumber ) ) ( (lv_j_1_0= ruleNumber ) ) )
            // InternalDume.g:470:3: ( (lv_i_0_0= ruleNumber ) ) ( (lv_j_1_0= ruleNumber ) )
            {
            // InternalDume.g:470:3: ( (lv_i_0_0= ruleNumber ) )
            // InternalDume.g:471:4: (lv_i_0_0= ruleNumber )
            {
            // InternalDume.g:471:4: (lv_i_0_0= ruleNumber )
            // InternalDume.g:472:5: lv_i_0_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPoint2DAccess().getINumberParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_i_0_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoint2DRule());
            					}
            					set(
            						current,
            						"i",
            						lv_i_0_0,
            						"dume.compiler.Dume.Number");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDume.g:489:3: ( (lv_j_1_0= ruleNumber ) )
            // InternalDume.g:490:4: (lv_j_1_0= ruleNumber )
            {
            // InternalDume.g:490:4: (lv_j_1_0= ruleNumber )
            // InternalDume.g:491:5: lv_j_1_0= ruleNumber
            {

            					newCompositeNode(grammarAccess.getPoint2DAccess().getJNumberParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_j_1_0=ruleNumber();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPoint2DRule());
            					}
            					set(
            						current,
            						"j",
            						lv_j_1_0,
            						"dume.compiler.Dume.Number");
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
    // $ANTLR end "rulePoint2D"


    // $ANTLR start "entryRulePoint"
    // InternalDume.g:512:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalDume.g:512:46: (iv_rulePoint= rulePoint EOF )
            // InternalDume.g:513:2: iv_rulePoint= rulePoint EOF
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
    // InternalDume.g:519:1: rulePoint returns [EObject current=null] : (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Point3D_0 = null;

        EObject this_Point2D_1 = null;

        AntlrDatatypeRuleToken lv_map_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:525:2: ( (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) ) )
            // InternalDume.g:526:2: (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) )
            {
            // InternalDume.g:526:2: (this_Point3D_0= rulePoint3D | (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==14) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==RULE_INT) ) {
                            int LA6_6 = input.LA(5);

                            if ( (LA6_6==21) ) {
                                alt6=2;
                            }
                            else if ( (LA6_6==RULE_INT||LA6_6==14) ) {
                                alt6=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 4, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_3==RULE_INT) ) {
                        int LA6_5 = input.LA(4);

                        if ( (LA6_5==21) ) {
                            alt6=2;
                        }
                        else if ( (LA6_5==RULE_INT||LA6_5==14) ) {
                            alt6=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==RULE_INT) ) {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==14) ) {
                    int LA6_4 = input.LA(3);

                    if ( (LA6_4==RULE_INT) ) {
                        int LA6_6 = input.LA(4);

                        if ( (LA6_6==21) ) {
                            alt6=2;
                        }
                        else if ( (LA6_6==RULE_INT||LA6_6==14) ) {
                            alt6=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 4, input);

                        throw nvae;
                    }
                }
                else if ( (LA6_2==RULE_INT) ) {
                    int LA6_5 = input.LA(3);

                    if ( (LA6_5==21) ) {
                        alt6=2;
                    }
                    else if ( (LA6_5==RULE_INT||LA6_5==14) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalDume.g:527:3: this_Point3D_0= rulePoint3D
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
                    // InternalDume.g:536:3: (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) )
                    {
                    // InternalDume.g:536:3: (this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) )
                    // InternalDume.g:537:4: this_Point2D_1= rulePoint2D otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) )
                    {

                    				newCompositeNode(grammarAccess.getPointAccess().getPoint2DParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_9);
                    this_Point2D_1=rulePoint2D();

                    state._fsp--;


                    				current = this_Point2D_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,21,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getPointAccess().getOnKeyword_1_1());
                    			
                    // InternalDume.g:549:4: ( (lv_map_3_0= ruleMap ) )
                    // InternalDume.g:550:5: (lv_map_3_0= ruleMap )
                    {
                    // InternalDume.g:550:5: (lv_map_3_0= ruleMap )
                    // InternalDume.g:551:6: lv_map_3_0= ruleMap
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
    // InternalDume.g:573:1: entryRuleShape returns [EObject current=null] : iv_ruleShape= ruleShape EOF ;
    public final EObject entryRuleShape() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape = null;


        try {
            // InternalDume.g:573:46: (iv_ruleShape= ruleShape EOF )
            // InternalDume.g:574:2: iv_ruleShape= ruleShape EOF
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
    // InternalDume.g:580:1: ruleShape returns [EObject current=null] : (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle ) ;
    public final EObject ruleShape() throws RecognitionException {
        EObject current = null;

        EObject this_Shape2D_0 = null;

        EObject this_Shape3D_1 = null;

        EObject this_Circle_2 = null;



        	enterRule();

        try {
            // InternalDume.g:586:2: ( (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle ) )
            // InternalDume.g:587:2: (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle )
            {
            // InternalDume.g:587:2: (this_Shape2D_0= ruleShape2D | this_Shape3D_1= ruleShape3D | this_Circle_2= ruleCircle )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==21) ) {
                    alt7=1;
                }
                else if ( (LA7_1==12) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==25) ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDume.g:588:3: this_Shape2D_0= ruleShape2D
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
                    // InternalDume.g:597:3: this_Shape3D_1= ruleShape3D
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
                    // InternalDume.g:606:3: this_Circle_2= ruleCircle
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
    // InternalDume.g:618:1: entryRuleShape3D returns [EObject current=null] : iv_ruleShape3D= ruleShape3D EOF ;
    public final EObject entryRuleShape3D() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape3D = null;


        try {
            // InternalDume.g:618:48: (iv_ruleShape3D= ruleShape3D EOF )
            // InternalDume.g:619:2: iv_ruleShape3D= ruleShape3D EOF
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
    // InternalDume.g:625:1: ruleShape3D returns [EObject current=null] : ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' ) ;
    public final EObject ruleShape3D() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_points_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:631:2: ( ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' ) )
            // InternalDume.g:632:2: ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' )
            {
            // InternalDume.g:632:2: ( () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}' )
            // InternalDume.g:633:3: () otherlv_1= 'shape' otherlv_2= '{' ( (lv_points_3_0= rulePoint3D ) )* otherlv_4= '}'
            {
            // InternalDume.g:633:3: ()
            // InternalDume.g:634:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape3DAccess().getShape3DAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getShape3DAccess().getShapeKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getShape3DAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:648:3: ( (lv_points_3_0= rulePoint3D ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_INT||LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalDume.g:649:4: (lv_points_3_0= rulePoint3D )
            	    {
            	    // InternalDume.g:649:4: (lv_points_3_0= rulePoint3D )
            	    // InternalDume.g:650:5: lv_points_3_0= rulePoint3D
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
            	    break loop8;
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
    // InternalDume.g:675:1: entryRuleShape2D returns [EObject current=null] : iv_ruleShape2D= ruleShape2D EOF ;
    public final EObject entryRuleShape2D() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShape2D = null;


        try {
            // InternalDume.g:675:48: (iv_ruleShape2D= ruleShape2D EOF )
            // InternalDume.g:676:2: iv_ruleShape2D= ruleShape2D EOF
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
    // InternalDume.g:682:1: ruleShape2D returns [EObject current=null] : ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' ) ;
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
            // InternalDume.g:688:2: ( ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' ) )
            // InternalDume.g:689:2: ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' )
            {
            // InternalDume.g:689:2: ( () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}' )
            // InternalDume.g:690:3: () otherlv_1= 'shape' otherlv_2= 'on' ( (lv_map_3_0= ruleMap ) ) otherlv_4= '{' ( (lv_points_5_0= rulePoint2D ) )* otherlv_6= '}'
            {
            // InternalDume.g:690:3: ()
            // InternalDume.g:691:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getShape2DAccess().getShape2DAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getShape2DAccess().getShapeKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getShape2DAccess().getOnKeyword_2());
            		
            // InternalDume.g:705:3: ( (lv_map_3_0= ruleMap ) )
            // InternalDume.g:706:4: (lv_map_3_0= ruleMap )
            {
            // InternalDume.g:706:4: (lv_map_3_0= ruleMap )
            // InternalDume.g:707:5: lv_map_3_0= ruleMap
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
            		
            // InternalDume.g:728:3: ( (lv_points_5_0= rulePoint2D ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_INT||LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalDume.g:729:4: (lv_points_5_0= rulePoint2D )
            	    {
            	    // InternalDume.g:729:4: (lv_points_5_0= rulePoint2D )
            	    // InternalDume.g:730:5: lv_points_5_0= rulePoint2D
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
            	    break loop9;
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
    // InternalDume.g:755:1: entryRuleDrawing returns [EObject current=null] : iv_ruleDrawing= ruleDrawing EOF ;
    public final EObject entryRuleDrawing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDrawing = null;


        try {
            // InternalDume.g:755:48: (iv_ruleDrawing= ruleDrawing EOF )
            // InternalDume.g:756:2: iv_ruleDrawing= ruleDrawing EOF
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
    // InternalDume.g:762:1: ruleDrawing returns [EObject current=null] : ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' ) ;
    public final EObject ruleDrawing() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_shapes_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:768:2: ( ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' ) )
            // InternalDume.g:769:2: ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' )
            {
            // InternalDume.g:769:2: ( () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}' )
            // InternalDume.g:770:3: () otherlv_1= 'drawing' otherlv_2= '{' ( (lv_shapes_3_0= ruleShape ) )* otherlv_4= '}'
            {
            // InternalDume.g:770:3: ()
            // InternalDume.g:771:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDrawingAccess().getDrawingAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getDrawingAccess().getDrawingKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getDrawingAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDume.g:785:3: ( (lv_shapes_3_0= ruleShape ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22||LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalDume.g:786:4: (lv_shapes_3_0= ruleShape )
            	    {
            	    // InternalDume.g:786:4: (lv_shapes_3_0= ruleShape )
            	    // InternalDume.g:787:5: lv_shapes_3_0= ruleShape
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
            	    break loop10;
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


    // $ANTLR start "entryRuleGo"
    // InternalDume.g:812:1: entryRuleGo returns [EObject current=null] : iv_ruleGo= ruleGo EOF ;
    public final EObject entryRuleGo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGo = null;


        try {
            // InternalDume.g:812:43: (iv_ruleGo= ruleGo EOF )
            // InternalDume.g:813:2: iv_ruleGo= ruleGo EOF
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
    // InternalDume.g:819:1: ruleGo returns [EObject current=null] : (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) ) ;
    public final EObject ruleGo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_point_1_0 = null;



        	enterRule();

        try {
            // InternalDume.g:825:2: ( (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) ) )
            // InternalDume.g:826:2: (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) )
            {
            // InternalDume.g:826:2: (otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) ) )
            // InternalDume.g:827:3: otherlv_0= 'go' ( (lv_point_1_0= rulePoint ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getGoAccess().getGoKeyword_0());
            		
            // InternalDume.g:831:3: ( (lv_point_1_0= rulePoint ) )
            // InternalDume.g:832:4: (lv_point_1_0= rulePoint )
            {
            // InternalDume.g:832:4: (lv_point_1_0= rulePoint )
            // InternalDume.g:833:5: lv_point_1_0= rulePoint
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
    // InternalDume.g:854:1: entryRuleCircle returns [EObject current=null] : iv_ruleCircle= ruleCircle EOF ;
    public final EObject entryRuleCircle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCircle = null;


        try {
            // InternalDume.g:854:47: (iv_ruleCircle= ruleCircle EOF )
            // InternalDume.g:855:2: iv_ruleCircle= ruleCircle EOF
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
    // InternalDume.g:861:1: ruleCircle returns [EObject current=null] : (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) ) ;
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
            // InternalDume.g:867:2: ( (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) ) )
            // InternalDume.g:868:2: (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) )
            {
            // InternalDume.g:868:2: (otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) ) )
            // InternalDume.g:869:3: otherlv_0= 'circle' otherlv_1= 'center' ( (lv_point_2_0= rulePoint2D ) ) otherlv_3= 'radius' ( (lv_radius_4_0= RULE_INT ) ) otherlv_5= 'on' ( (lv_map_6_0= ruleMap ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getCircleAccess().getCircleKeyword_0());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getCircleAccess().getCenterKeyword_1());
            		
            // InternalDume.g:877:3: ( (lv_point_2_0= rulePoint2D ) )
            // InternalDume.g:878:4: (lv_point_2_0= rulePoint2D )
            {
            // InternalDume.g:878:4: (lv_point_2_0= rulePoint2D )
            // InternalDume.g:879:5: lv_point_2_0= rulePoint2D
            {

            					newCompositeNode(grammarAccess.getCircleAccess().getPointPoint2DParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
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

            otherlv_3=(Token)match(input,27,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getCircleAccess().getRadiusKeyword_3());
            		
            // InternalDume.g:900:3: ( (lv_radius_4_0= RULE_INT ) )
            // InternalDume.g:901:4: (lv_radius_4_0= RULE_INT )
            {
            // InternalDume.g:901:4: (lv_radius_4_0= RULE_INT )
            // InternalDume.g:902:5: lv_radius_4_0= RULE_INT
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

            otherlv_5=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getCircleAccess().getOnKeyword_5());
            		
            // InternalDume.g:922:3: ( (lv_map_6_0= ruleMap ) )
            // InternalDume.g:923:4: (lv_map_6_0= ruleMap )
            {
            // InternalDume.g:923:4: (lv_map_6_0= ruleMap )
            // InternalDume.g:924:5: lv_map_6_0= ruleMap
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
    // InternalDume.g:945:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalDume.g:945:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalDume.g:946:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalDume.g:952:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_n_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_instructions_3_0 = null;



        	enterRule();

        try {
            // InternalDume.g:958:2: ( (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' ) )
            // InternalDume.g:959:2: (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            {
            // InternalDume.g:959:2: (otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}' )
            // InternalDume.g:960:3: otherlv_0= 'loop' ( (lv_n_1_0= RULE_INT ) ) otherlv_2= '{' ( (lv_instructions_3_0= ruleInstruction ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
            		
            // InternalDume.g:964:3: ( (lv_n_1_0= RULE_INT ) )
            // InternalDume.g:965:4: (lv_n_1_0= RULE_INT )
            {
            // InternalDume.g:965:4: (lv_n_1_0= RULE_INT )
            // InternalDume.g:966:5: lv_n_1_0= RULE_INT
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
            		
            // InternalDume.g:986:3: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=23 && LA11_0<=24)||LA11_0==28) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDume.g:987:4: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // InternalDume.g:987:4: (lv_instructions_3_0= ruleInstruction )
            	    // InternalDume.g:988:5: lv_instructions_3_0= ruleInstruction
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
            	    break loop11;
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
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000011802000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002402000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});

}