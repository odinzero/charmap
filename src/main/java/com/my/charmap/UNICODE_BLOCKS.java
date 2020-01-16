package com.my.charmap;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.Character.UnicodeBlock;
import java.util.*;
import javax.swing.*;

public class UNICODE_BLOCKS  implements ItemListener {

    String[] codes16 = {
        "Basic Latin",
        "Latin-1 Supplement",
        "Latin Extended-A",
        "Latin Extended-B",
        "IPA Extensions",
        "Spacing Modifier Letters",
        "Combining Diacritical Marks",
        "Greek",
        "Cyrillic",
        "Cyrillic Supplement",
        "Armenian",
        "Hebrew",
        "Arabic",
        "Syriac",
        "Thaana: Maldives",
        "Mandic: African",
        "Devanagari: Hindi",
        "Bengali",
        "Gurmukhi: Punjabi",
        "Gujarati: Gujarat",
        "Oriya: Odiya Orissa",
        "Tamil: India and Sri Lanka",
        "Telugu: Andhra Pradesh",
        "Kannada: Karnataka",
        "Malayalam: Kerala",
        "Sinhala: Sri Lanka",
        "Thai",
        "Lao",
        "Tibetan",
        "Myanmar",
        "Georgian",
        "Hangul Jamo: Korean",
        "Ethiopic",
        "Cherokee",
        "Canadian Aboriginal Syllabic",
        "Ogham: Old Irish",
        "Runic",
        "Tagalog: Philippino",
        "Hanunoo: Mindoro in the Philippines",
        "Buhid: Mindoro in the Philippines, used to write Tagalog",
        "Tagbanwa: Philippines",
        "Khmer: Cambodian",
        "Mongolian",
        "Limbu: Tibet/Burma",
        "Tai Le: China",
        "Khmer Symbols: Cambodian",
        "Batak: Sumatra Indonesia",
        "Phonetic Extensions",
        "Latin Extended Additional: dotted letters, letters with two accents",
        "Greek Extended",
        "General Punctuation",
        "Superscripts and Subscripts",
        "Currency Symbols: including new 20b9 Rupee",
        "Combining Marks for Symbols",
        "Letterlike Symbols",
        "Number Forms",
        "Mathematical Operators: ",
        "Miscellaneous Technical: APL operators",
        "Control Pictures: for displaying unprintable ASCII control chararacters",
        "Optical Character Recognition",
        "Enclosed Alphanumerics: see Dingbats 2700 for more circled digits",
        "Box Drawing: single/double lines also triangles",
        "Block Elements",
        "Geometric Shapes",
        "Miscellaneous Symbols: chess, astrology, I-ching, telephones, hazards, religious symbols, hammer and sickle",
        "Dingbats: asterisks, ornaments, hands, right-pointing arrows, pencils, scissors, pens. See 2460 for more circled digits",
        "Miscellaneous Mathematical Symbols-A: including SQL left, right and full joins",
        "Supplemental Arrows-A",
        "Braille Patterns",
        "Supplemental Arrows-B",
        "Miscellaneous Mathematical Symbols-B",
        "Supplemental Mathematical Operators: including variants of + - × ÷",
        "Miscellaneous Symbols and Arrows",
        "Glagolytic: pre Cyrillic Bulgarian",
        "CJK Radicals Supplement: Chinese Japanese Korean",
        "Kangxi Radicals: fragments combined to write Chinese",
        "Ideographic Description Characters",
        "CJK Symbols and Punctuation: Chinese Japanese Korean",
        "Hiragana: (Japanese) Used when no Kanji character exists",
        "Katakana: (Japanese) mainly for foreign names",
        "Bopomofo: phonetic script for Mandarin",
        "Hangul Compatibility Jamo: Korean",
        "Kanbun: used by Japanese to annotate classic Chinese",
        "Bopomofo Extended: phonetic script for Mandarin",
        "Katakana Phonetic Extensions: Japanese",
        "Enclosed CJK Letters and Months: Chinese Japanese Korean",
        "CJK Compatibility: Chinese Japanese Korean",
        "CJK Unified Ideographs Extension A: Chinese Japanese Korean",
        "Yijing Hexagram Symbols: I Ching symbols",
        "CJK Unified Ideographs: Chinese Japanese Korean including Kanji digitsYijing Hexagram Symbols: I Ching symbols",
        "Yi Syllables: classical Yi language of China",
        "Yi Radicals: classical Yi language of China",
        "Ethiopic Extended-A",
        "Hangul Syllables: Korean",
        "High Surrogates",
        "Low Surrogates",
        "Private Use Area",
        "CJK Compatibility Ideographs: Chinese Japanese Korean",
        "Alphabetic Presentation Forms: ligatures including Hebrew",
        "Arabic Presentation Forms-A",
        "Variation Selectors: non-printing control characters",
        "Combining Half Marks",
        "CJK Compatibility Forms: Chinese, Japanese, Korean vertical brackets",
        "Small Form Variants: small punctuation",
        "Arabic Presentation Forms-B",
        "Halfwidth and Fullwidth Forms: wide and narrow letters, digits and punctuation",
        "Specials: byte order marks"
    };

         UnicodeBlock[] unicode = { Character.UnicodeBlock.AEGEAN_NUMBERS ,
                                    Character.UnicodeBlock.ALPHABETIC_PRESENTATION_FORMS ,
                                    Character.UnicodeBlock.ARABIC ,
                                    Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A ,
                                    Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B ,
                                    Character.UnicodeBlock.ARMENIAN ,
                                    Character.UnicodeBlock.ARROWS ,
                                    Character.UnicodeBlock.BASIC_LATIN ,
                                    Character.UnicodeBlock.BENGALI ,
                                    Character.UnicodeBlock.BLOCK_ELEMENTS ,
                                    Character.UnicodeBlock.BOPOMOFO ,
                                    Character.UnicodeBlock.BOPOMOFO_EXTENDED ,
                                    Character.UnicodeBlock.BOX_DRAWING ,
                                    Character.UnicodeBlock.BRAILLE_PATTERNS ,
                                    Character.UnicodeBlock.BUHID,
                                    Character.UnicodeBlock.BYZANTINE_MUSICAL_SYMBOLS,
                                    Character.UnicodeBlock.CHEROKEE,
                                    Character.UnicodeBlock.CJK_COMPATIBILITY,
                                    Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS,
                                    Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS,
                                    Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT,
                                    Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT,
                                    Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION,
                                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS,
                                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A,
                                    Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B,
                                    Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS,
                                    Character.UnicodeBlock.COMBINING_HALF_MARKS,
                                    Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS,
                                    Character.UnicodeBlock.CONTROL_PICTURES,
                                    Character.UnicodeBlock.CURRENCY_SYMBOLS,
                                    Character.UnicodeBlock.CYPRIOT_SYLLABARY,
                                    Character.UnicodeBlock.CYRILLIC,
                                    Character.UnicodeBlock.CYRILLIC_SUPPLEMENTARY,
                                    Character.UnicodeBlock.DESERET,
                                    Character.UnicodeBlock.DEVANAGARI,
                                    Character.UnicodeBlock.DINGBATS,
                                    Character.UnicodeBlock.DINGBATS,
                                    Character.UnicodeBlock.ENCLOSED_ALPHANUMERICS,
                                    Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS,
                                    Character.UnicodeBlock.ETHIOPIC,
                                    Character.UnicodeBlock.GENERAL_PUNCTUATION,
                                    Character.UnicodeBlock.GEOMETRIC_SHAPES,
                                    Character.UnicodeBlock.GEORGIAN,
                                    Character.UnicodeBlock.GOTHIC,
                                    Character.UnicodeBlock.GREEK,
                                    Character.UnicodeBlock.GREEK_EXTENDED,
                                    Character.UnicodeBlock.GUJARATI,
                                    Character.UnicodeBlock.GURMUKHI,
                                    Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS,
                                    Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO,
                                    Character.UnicodeBlock.HANGUL_JAMO,
                                    Character.UnicodeBlock.HANGUL_SYLLABLES,
                                    Character.UnicodeBlock.HANUNOO,
                                    Character.UnicodeBlock.HEBREW,
                                    Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES,
                                    Character.UnicodeBlock.HIGH_SURROGATES,
                                    Character.UnicodeBlock.HIRAGANA,
                                    Character.UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS,
                                    Character.UnicodeBlock.IPA_EXTENSIONS,
                                    Character.UnicodeBlock.KANBUN,
                                    Character.UnicodeBlock.KANGXI_RADICALS,
                                    Character.UnicodeBlock.KANNADA,
                                    Character.UnicodeBlock.KATAKANA,
                                    Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS,
                                    Character.UnicodeBlock.KHMER,
                                    Character.UnicodeBlock.KHMER_SYMBOLS,
                                    Character.UnicodeBlock.LAO,
                                    Character.UnicodeBlock.LATIN_1_SUPPLEMENT,
                                    Character.UnicodeBlock.LATIN_EXTENDED_A,
                                    Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL,
                                    Character.UnicodeBlock.LATIN_EXTENDED_B,
                                    Character.UnicodeBlock.LETTERLIKE_SYMBOLS,
                                    Character.UnicodeBlock.LIMBU,
                                    Character.UnicodeBlock.LINEAR_B_IDEOGRAMS,
                                    Character.UnicodeBlock.LINEAR_B_SYLLABARY,
                                    Character.UnicodeBlock.LOW_SURROGATES,
                                    Character.UnicodeBlock.MALAYALAM,
                                    Character.UnicodeBlock.MATHEMATICAL_ALPHANUMERIC_SYMBOLS,
                                    Character.UnicodeBlock.MATHEMATICAL_OPERATORS,
                                    Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A,
                                    Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B,
                                    Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS,
                                    Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS,
                                    Character.UnicodeBlock.MISCELLANEOUS_TECHNICAL,
                                    Character.UnicodeBlock.MONGOLIAN,
                                    Character.UnicodeBlock.MUSICAL_SYMBOLS,
                                    Character.UnicodeBlock.MYANMAR,
                                    Character.UnicodeBlock.NUMBER_FORMS,
                                    Character.UnicodeBlock.OGHAM,
                                    Character.UnicodeBlock.OLD_ITALIC,
                                    Character.UnicodeBlock.OPTICAL_CHARACTER_RECOGNITION,
                                    Character.UnicodeBlock.ORIYA,
                                    Character.UnicodeBlock.OSMANYA,
                                    Character.UnicodeBlock.PHONETIC_EXTENSIONS,
                                    Character.UnicodeBlock.PRIVATE_USE_AREA,
                                    Character.UnicodeBlock.RUNIC,
                                    Character.UnicodeBlock.SHAVIAN,
                                    Character.UnicodeBlock.SINHALA,
                                    Character.UnicodeBlock.SMALL_FORM_VARIANTS,
                                    Character.UnicodeBlock.SPACING_MODIFIER_LETTERS,
                                    Character.UnicodeBlock.SPECIALS,
                                    Character.UnicodeBlock.SUPERSCRIPTS_AND_SUBSCRIPTS,
                                    Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_A,
                                    Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_B,
                                    Character.UnicodeBlock.SUPPLEMENTAL_MATHEMATICAL_OPERATORS,
                                    Character.UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_A,
                                    Character.UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_B,
                                    Character.UnicodeBlock.SYRIAC,
                                    Character.UnicodeBlock.TAGALOG,
                                    Character.UnicodeBlock.TAGBANWA,
                                    Character.UnicodeBlock.TAGS,
                                    Character.UnicodeBlock.TAI_LE,
                                    Character.UnicodeBlock.TAI_XUAN_JING_SYMBOLS,
                                    Character.UnicodeBlock.TAMIL,
                                    Character.UnicodeBlock.TELUGU,
                                    Character.UnicodeBlock.THAANA,
                                    Character.UnicodeBlock.THAI,
                                    Character.UnicodeBlock.TIBETAN,
                                    Character.UnicodeBlock.UGARITIC,
                                    Character.UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS,
                                    Character.UnicodeBlock.VARIATION_SELECTORS,
                                    Character.UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT,
                                    Character.UnicodeBlock.YIJING_HEXAGRAM_SYMBOLS,
                                    Character.UnicodeBlock.YI_RADICALS,
                                    Character.UnicodeBlock.YI_SYLLABLES
                               };


    JComboBox checkbox;
    UNICODE unicodes;

    UNICODE_BLOCKS(UNICODE uni) {
      unicodes = uni;

      
//        checkbox  = new JComboBox(codes16);
        checkbox  = new JComboBox(unicode);
        checkbox.setSelectedIndex(7);
        checkbox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         Object sel =  checkbox.getSelectedItem();
              if(e.getItem() == sel )
              {
                  unicodes.p.removeAll();

                  Character.UnicodeBlock arabic_b = (UnicodeBlock) sel;
                  final Set<Character> chars = new HashSet<Character>();
            for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
               if ( arabic_b == Character.UnicodeBlock.of(codePoint) ) {
                   chars.add((char) codePoint);
        }
        }
           UNI_symbol_view[] labels = new UNI_symbol_view[chars.size()] ;
           Character[] s =   chars.toArray(new Character[chars.size()]);
           int x1 = 0; int y1 = 5;
          for( int k = 0; k < s.length ; k++ ) {
               x1 += 30;
             if( x1 >= 500)  {
               x1 = 30;  y1 += 30;
             // set maximum Height of viewPort
             unicodes.viewportHeight = (y1 + 60);
             unicodes.setViewPortHeight( unicodes.jv1 , unicodes.viewportHeight);
             }
               String str = Character.toString(s[k]);

              labels[k] = new UNI_symbol_view( unicodes ,str );
              labels[k].setBounds(x1  , y1  , 31,  31);
              unicodes.p.add(labels[k]);

              unicodes.repaint();
              
          }
              } 

    }

   
}
