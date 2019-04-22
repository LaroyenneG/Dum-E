/*
 * generated by Xtext 2.17.0
 */
grammar InternalDume;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package dume.compiler.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleScripts
entryRuleScripts returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScriptsRule()); }
	iv_ruleScripts=ruleScripts
	{ $current=$iv_ruleScripts.current; }
	EOF;

// Rule Scripts
ruleScripts returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getScriptsAccess().getScriptScriptParserRuleCall_0());
			}
			lv_script_0_0=ruleScript
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getScriptsRule());
				}
				add(
					$current,
					"script",
					lv_script_0_0,
					"dume.compiler.Dume.Script");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleScript
entryRuleScript returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getScriptRule()); }
	iv_ruleScript=ruleScript
	{ $current=$iv_ruleScript.current; }
	EOF;

// Rule Script
ruleScript returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Script'
		{
			newLeafNode(otherlv_0, grammarAccess.getScriptAccess().getScriptKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getScriptAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getScriptRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getScriptAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getScriptAccess().getInstructionsInstructionParserRuleCall_3_0());
				}
				lv_instructions_3_0=ruleInstruction
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getScriptRule());
					}
					add(
						$current,
						"instructions",
						lv_instructions_3_0,
						"dume.compiler.Dume.Instruction");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getScriptAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleInstruction
entryRuleInstruction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInstructionRule()); }
	iv_ruleInstruction=ruleInstruction
	{ $current=$iv_ruleInstruction.current; }
	EOF;

// Rule Instruction
ruleInstruction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getDrawingParserRuleCall_0());
		}
		this_Drawing_0=ruleDrawing
		{
			$current = $this_Drawing_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getClearParserRuleCall_1());
		}
		this_Clear_1=ruleClear
		{
			$current = $this_Clear_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getGoParserRuleCall_2());
		}
		this_Go_2=ruleGo
		{
			$current = $this_Go_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getLoopParserRuleCall_3());
		}
		this_Loop_3=ruleLoop
		{
			$current = $this_Loop_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleMap
entryRuleMap returns [String current=null]:
	{ newCompositeNode(grammarAccess.getMapRule()); }
	iv_ruleMap=ruleMap
	{ $current=$iv_ruleMap.current.getText(); }
	EOF;

// Rule Map
ruleMap returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='A'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getAKeyword_0());
		}
		    |
		kw='B'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getBKeyword_1());
		}
		    |
		kw='C'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getCKeyword_2());
		}
		    |
		kw='D'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getDKeyword_3());
		}
		    |
		kw='E'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getEKeyword_4());
		}
		    |
		kw='F'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getMapAccess().getFKeyword_5());
		}
	)
;

// Entry rule entryRulePoint3D
entryRulePoint3D returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPoint3DRule()); }
	iv_rulePoint3D=rulePoint3D
	{ $current=$iv_rulePoint3D.current; }
	EOF;

// Rule Point3D
rulePoint3D returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getPoint3DAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				lv_x_1_0=RULE_INT
				{
					newLeafNode(lv_x_1_0, grammarAccess.getPoint3DAccess().getXINTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPoint3DRule());
					}
					setWithLastConsumed(
						$current,
						"x",
						lv_x_1_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		(
			(
				lv_y_2_0=RULE_INT
				{
					newLeafNode(lv_y_2_0, grammarAccess.getPoint3DAccess().getYINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPoint3DRule());
					}
					setWithLastConsumed(
						$current,
						"y",
						lv_y_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		(
			(
				lv_z_3_0=RULE_INT
				{
					newLeafNode(lv_z_3_0, grammarAccess.getPoint3DAccess().getZINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPoint3DRule());
					}
					setWithLastConsumed(
						$current,
						"z",
						lv_z_3_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getPoint3DAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRulePoint2D
entryRulePoint2D returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPoint2DRule()); }
	iv_rulePoint2D=rulePoint2D
	{ $current=$iv_rulePoint2D.current; }
	EOF;

// Rule Point2D
rulePoint2D returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getPoint2DAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				lv_i_1_0=RULE_INT
				{
					newLeafNode(lv_i_1_0, grammarAccess.getPoint2DAccess().getIINTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPoint2DRule());
					}
					setWithLastConsumed(
						$current,
						"i",
						lv_i_1_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		(
			(
				lv_j_2_0=RULE_INT
				{
					newLeafNode(lv_j_2_0, grammarAccess.getPoint2DAccess().getJINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPoint2DRule());
					}
					setWithLastConsumed(
						$current,
						"j",
						lv_j_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getPoint2DAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRulePoint
entryRulePoint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPointRule()); }
	iv_rulePoint=rulePoint
	{ $current=$iv_rulePoint.current; }
	EOF;

// Rule Point
rulePoint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPointAccess().getPoint3DParserRuleCall_0());
		}
		this_Point3D_0=rulePoint3D
		{
			$current = $this_Point3D_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			{
				newCompositeNode(grammarAccess.getPointAccess().getPoint2DParserRuleCall_1_0());
			}
			this_Point2D_1=rulePoint2D
			{
				$current = $this_Point2D_1.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_2='on'
			{
				newLeafNode(otherlv_2, grammarAccess.getPointAccess().getOnKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getPointAccess().getMapMapParserRuleCall_1_2_0());
					}
					lv_map_3_0=ruleMap
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPointRule());
						}
						set(
							$current,
							"map",
							lv_map_3_0,
							"dume.compiler.Dume.Map");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleShape
entryRuleShape returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShapeRule()); }
	iv_ruleShape=ruleShape
	{ $current=$iv_ruleShape.current; }
	EOF;

// Rule Shape
ruleShape returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getShapeAccess().getShape2DParserRuleCall_0());
		}
		this_Shape2D_0=ruleShape2D
		{
			$current = $this_Shape2D_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getShapeAccess().getShape3DParserRuleCall_1());
		}
		this_Shape3D_1=ruleShape3D
		{
			$current = $this_Shape3D_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getShapeAccess().getCircleParserRuleCall_2());
		}
		this_Circle_2=ruleCircle
		{
			$current = $this_Circle_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleShape3D
entryRuleShape3D returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShape3DRule()); }
	iv_ruleShape3D=ruleShape3D
	{ $current=$iv_ruleShape3D.current; }
	EOF;

// Rule Shape3D
ruleShape3D returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getShape3DAccess().getShape3DAction_0(),
					$current);
			}
		)
		otherlv_1='shape'
		{
			newLeafNode(otherlv_1, grammarAccess.getShape3DAccess().getShapeKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getShape3DAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getShape3DAccess().getPointsPoint3DParserRuleCall_3_0());
				}
				lv_points_3_0=rulePoint3D
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getShape3DRule());
					}
					add(
						$current,
						"points",
						lv_points_3_0,
						"dume.compiler.Dume.Point3D");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getShape3DAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleShape2D
entryRuleShape2D returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getShape2DRule()); }
	iv_ruleShape2D=ruleShape2D
	{ $current=$iv_ruleShape2D.current; }
	EOF;

// Rule Shape2D
ruleShape2D returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getShape2DAccess().getShape2DAction_0(),
					$current);
			}
		)
		otherlv_1='shape'
		{
			newLeafNode(otherlv_1, grammarAccess.getShape2DAccess().getShapeKeyword_1());
		}
		otherlv_2='on'
		{
			newLeafNode(otherlv_2, grammarAccess.getShape2DAccess().getOnKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getShape2DAccess().getMapMapParserRuleCall_3_0());
				}
				lv_map_3_0=ruleMap
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getShape2DRule());
					}
					set(
						$current,
						"map",
						lv_map_3_0,
						"dume.compiler.Dume.Map");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4='{'
		{
			newLeafNode(otherlv_4, grammarAccess.getShape2DAccess().getLeftCurlyBracketKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getShape2DAccess().getPointsPoint2DParserRuleCall_5_0());
				}
				lv_points_5_0=rulePoint2D
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getShape2DRule());
					}
					add(
						$current,
						"points",
						lv_points_5_0,
						"dume.compiler.Dume.Point2D");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getShape2DAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleDrawing
entryRuleDrawing returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDrawingRule()); }
	iv_ruleDrawing=ruleDrawing
	{ $current=$iv_ruleDrawing.current; }
	EOF;

// Rule Drawing
ruleDrawing returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getDrawingAccess().getDrawingAction_0(),
					$current);
			}
		)
		otherlv_1='drawing'
		{
			newLeafNode(otherlv_1, grammarAccess.getDrawingAccess().getDrawingKeyword_1());
		}
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getDrawingAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDrawingAccess().getShapesShapeParserRuleCall_3_0());
				}
				lv_shapes_3_0=ruleShape
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDrawingRule());
					}
					add(
						$current,
						"shapes",
						lv_shapes_3_0,
						"dume.compiler.Dume.Shape");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getDrawingAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleClear
entryRuleClear returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getClearRule()); }
	iv_ruleClear=ruleClear
	{ $current=$iv_ruleClear.current; }
	EOF;

// Rule Clear
ruleClear returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getClearAccess().getClearAction_0(),
					$current);
			}
		)
		otherlv_1='clear'
		{
			newLeafNode(otherlv_1, grammarAccess.getClearAccess().getClearKeyword_1());
		}
	)
;

// Entry rule entryRuleGo
entryRuleGo returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getGoRule()); }
	iv_ruleGo=ruleGo
	{ $current=$iv_ruleGo.current; }
	EOF;

// Rule Go
ruleGo returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='go'
		{
			newLeafNode(otherlv_0, grammarAccess.getGoAccess().getGoKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getGoAccess().getPointPointParserRuleCall_1_0());
				}
				lv_point_1_0=rulePoint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getGoRule());
					}
					set(
						$current,
						"point",
						lv_point_1_0,
						"dume.compiler.Dume.Point");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCircle
entryRuleCircle returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCircleRule()); }
	iv_ruleCircle=ruleCircle
	{ $current=$iv_ruleCircle.current; }
	EOF;

// Rule Circle
ruleCircle returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='circle'
		{
			newLeafNode(otherlv_0, grammarAccess.getCircleAccess().getCircleKeyword_0());
		}
		otherlv_1='center'
		{
			newLeafNode(otherlv_1, grammarAccess.getCircleAccess().getCenterKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCircleAccess().getPointPoint2DParserRuleCall_2_0());
				}
				lv_point_2_0=rulePoint2D
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCircleRule());
					}
					set(
						$current,
						"point",
						lv_point_2_0,
						"dume.compiler.Dume.Point2D");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3='radius'
		{
			newLeafNode(otherlv_3, grammarAccess.getCircleAccess().getRadiusKeyword_3());
		}
		(
			(
				lv_radius_4_0=RULE_INT
				{
					newLeafNode(lv_radius_4_0, grammarAccess.getCircleAccess().getRadiusINTTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCircleRule());
					}
					setWithLastConsumed(
						$current,
						"radius",
						lv_radius_4_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_5='on'
		{
			newLeafNode(otherlv_5, grammarAccess.getCircleAccess().getOnKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCircleAccess().getMapMapParserRuleCall_6_0());
				}
				lv_map_6_0=ruleMap
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCircleRule());
					}
					set(
						$current,
						"map",
						lv_map_6_0,
						"dume.compiler.Dume.Map");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLoop
entryRuleLoop returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLoopRule()); }
	iv_ruleLoop=ruleLoop
	{ $current=$iv_ruleLoop.current; }
	EOF;

// Rule Loop
ruleLoop returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='loop'
		{
			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getLoopKeyword_0());
		}
		(
			(
				lv_n_1_0=RULE_INT
				{
					newLeafNode(lv_n_1_0, grammarAccess.getLoopAccess().getNINTTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getLoopRule());
					}
					setWithLastConsumed(
						$current,
						"n",
						lv_n_1_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getLoopAccess().getInstructionsInstructionParserRuleCall_3_0());
				}
				lv_instructions_3_0=ruleInstruction
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getLoopRule());
					}
					add(
						$current,
						"instructions",
						lv_instructions_3_0,
						"dume.compiler.Dume.Instruction");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;