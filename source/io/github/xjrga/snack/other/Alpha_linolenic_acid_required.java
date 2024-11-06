package io.github.xjrga.snack.other;

import java.math.BigDecimal;

public class Alpha_linolenic_acid_required {
  private final BigDecimal energy;

  public Alpha_linolenic_acid_required(Double energy) {
    BigDecimal q = new BigDecimal(energy);
    // .setScale(scale, RoundingMode.HALF_UP)
    this.energy = q;
  }

  public BigDecimal get_low_in_grams() {
    return energy.multiply(new BigDecimal(.006 / 9.0));
  }

  public BigDecimal get_high_in_grams() {
    return energy.multiply(new BigDecimal(.012 / 9.0));
  }
}
// -
// Stark, A.H., Crawford, M.A. and Reifen, R., 2008. Update on alpha-linolenic acid. Nutrition
// reviews, 66(6), pp.326-332.
// -
// Simopoulos, A.P., 2006. Evolutionary aspects of diet, the omega-6/omega-3 ratio and genetic
// variation: nutritional implications for chronic diseases. Biomedicine & pharmacotherapy, 60(9),
// pp.502-507.
// Anthropological and epidemiological studies and studies at the molecular level indicate that
// human beings evolved on a diet with a ratio of omega-6 to omega-3 essential fatty acids (EFA) of
// ~1 whereas in Western diets the ratio is 15/1 to 16.7/1.
// -
// Davis, B.C. and Kris-Etherton, P.M., 2003. Achieving optimal essential fatty acid status in
// vegetarians: current knowledge and practical implications. The American journal of clinical
// nutrition, 78(3), pp.640S-646S.
// A number of recommendations have been made on the basis of the ratio of n6 to n3 fatty acids.
// The World Health Organization/Food and Agriculture Organization suggests a ratio of 5:1–10:1,
// Sweden recommends a ratio of 5:1, Canada recommends 4:1–10:1,and Japan recently changed its
// recommendation from 4:1 to 2:1. On the basis of the proposed AIs, the NIH suggests a ratio of
// 2:1–3:1. One study found that a ratio of 4:1 allows for adequate conversion to DHA in healthy
// vegetarians. Another research group suggested that the optimal ratio to maximize the conversion
// of ALA to DHA is 2.3:1. Given the rate of conversion of ALA to EPA and DHA, it has been suggested
// that a safe and adequate ratio for the vegetarian and vegan populations would be in the range of
// 2:1–4:1.
