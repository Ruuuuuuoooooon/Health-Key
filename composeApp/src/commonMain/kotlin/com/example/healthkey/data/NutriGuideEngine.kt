package com.example.healthkey.data

import com.example.healthkey.data.model.NutriProfile

object NutriGuideEngine {

    fun getResponse(input: String, profile: NutriProfile): String {
        val q = input.lowercase()
        return when {
            // ── Breakfast ──────────────────────────────────────────────────────
            "breakfast" in q && profile == NutriProfile.DIABETIC ->
                "🌅 Diabetic breakfast: Try slata mechouia (grilled tomato & pepper salad) with 1 boiled egg and a slice of whole-grain bread. Avoid fruit juice — opt for black coffee or unsweetened herbal tea. This keeps your glycaemic load low while giving sustained energy."

            "breakfast" in q && profile == NutriProfile.ATHLETE ->
                "💪 Pre-workout breakfast: Assida (semolina porridge) with a drizzle of honey + 2 boiled eggs + a handful of dates. The bsissa mix (roasted barley & spices) is also excellent — 2 tbsp in warm milk gives long-lasting carb fuel."

            "breakfast" in q && profile == NutriProfile.PREGNANT ->
                "🤰 Breakfast during pregnancy: Lablabi broth (chickpea soup) is iron-rich and gentle on the stomach. Pair with a small fruit salad and one hard-boiled egg. Avoid very spicy harissa in the first trimester."

            "breakfast" in q && profile == NutriProfile.ELDERLY ->
                "🌿 Senior breakfast: Couscous with warm milk, a drizzle of argan oil, and some dried figs. Soft, easy to digest, and rich in calcium and fibre. Avoid skipping meals — metabolism slows with age."

            "breakfast" in q ->
                "🍳 Balanced breakfast: Slata mechouia, 1–2 eggs, whole-grain bread with olive oil. Tunisian breakfast tradition is naturally nutritious — stick to it!"

            // ── Lunch ─────────────────────────────────────────────────────────
            "lunch" in q && profile == NutriProfile.DIABETIC ->
                "🥗 Diabetic lunch: A half-portion of couscous (whole-grain if possible) with steamed vegetables — zucchini, turnip, carrot — and a small portion of chicken. Avoid adding the sweet tfaya (onion-raisin topping). Have a large salad first."

            "lunch" in q && profile == NutriProfile.ATHLETE ->
                "🏋️ Post-training lunch: Grilled merguez or chicken with whole-wheat pasta or couscous. Add a chickpea salad with lemon, cumin, and olive oil for protein + complex carbs. Target: 40g protein, 80g carbs."

            "lunch" in q ->
                "🍽️ Balanced Tunisian lunch: Couscous with vegetables and a lean protein (fish, chicken, or lentils). Harissa in moderation — it boosts metabolism. Finish with fresh fruit, not a heavy dessert."

            // ── Protein ───────────────────────────────────────────────────────
            "protein" in q && profile == NutriProfile.ATHLETE ->
                "🥩 Protein for athletes: Top Tunisian sources — grilled fish (loup de mer, dorade), chicken breast, canned tuna, eggs, and lentils. Aim for 1.6–2.2 g/kg of body weight daily. Bsissa + milk post-workout is a traditional recovery shake."

            "protein" in q && profile == NutriProfile.ELDERLY ->
                "🫘 Protein for seniors: Lablabi (chickpea soup) and merguez in small amounts are excellent. Fish 3× per week supports muscle maintenance. Eggs are a perfect daily protein source — easy to digest and nutrient-dense."

            "protein" in q ->
                "💊 Protein sources in Tunisian diet: Eggs, fish (tuna, sardines), chicken, lentils, chickpeas. Kefteji (egg & vegetable fritter) is a great protein-rich meal. Aim for a palm-sized protein portion at every meal."

            // ── Iron ──────────────────────────────────────────────────────────
            "iron" in q && profile == NutriProfile.PREGNANT ->
                "🌿 Iron during pregnancy: Lentil soup (shorba) is your best friend — high in iron and folate. Pair with a squeeze of lemon (vitamin C boosts absorption). Eat red meat 2–3× per week. Avoid drinking tea or coffee within 1 hour of iron-rich meals."

            "iron" in q ->
                "🩸 Iron-rich Tunisian foods: Lentils, chickpeas, spinach, red meat, sardines, and sesame seeds (used in bsissa). Pair plant-iron sources with vitamin C (lemon, peppers) to triple absorption. Shorba lentil soup daily is excellent."

            // ── Sugar ─────────────────────────────────────────────────────────
            "sugar" in q && profile == NutriProfile.DIABETIC ->
                "⚠️ Sugar management: Avoid white bread, juices, and Tunisian sweets like baklava daily. Dates are high-GI — limit to 1–2 at a time. Choose zlabia only as an occasional treat. Replace sugar with a small amount of raw honey in coffee."

            "sugar" in q ->
                "🍬 Reducing sugar: Traditional Tunisian sweets (makroudh, zlabia) are delicious but dense in sugar. Enjoy them for celebrations. Daily: use fresh fruit for sweetness. Khobz (bread) made from semolina has a lower glycaemic response than white flour."

            // ── Weight ────────────────────────────────────────────────────────
            "weight" in q && profile == NutriProfile.ATHLETE ->
                "⚖️ Weight management for athletes: Focus on body composition, not just weight. Increase protein, reduce refined carbs after 6 PM. Couscous at lunch (not dinner) is ideal. Track macros: ~40% carbs / 30% protein / 30% fat for lean muscle gain."

            "weight" in q ->
                "⚖️ Healthy weight in Tunisia: Cut fried foods (mloukhiya fried version, brik with oil) and add more steamed dishes. Shorba-based meals are filling and low-calorie. Walk after lunch — a Tunisian tradition that actually helps digestion and metabolism."

            // ── Heart ─────────────────────────────────────────────────────────
            "heart" in q ->
                "❤️ Heart health: The Tunisian diet is naturally Mediterranean. Olive oil (extra-virgin), fish, legumes, and vegetables are cardioprotective. Limit merguez and processed meats to 1× per week. Cumin and coriander (common in Tunisian spices) have anti-inflammatory properties."

            // ── Diet plan ─────────────────────────────────────────────────────
            "diet plan" in q || "meal plan" in q ->
                "📋 Sample Tunisian nutrition plan:\n• Breakfast: Eggs + slata mechouia + whole grain bread\n• Snack: 2 dates + small handful almonds\n• Lunch: Couscous + steamed vegetables + grilled fish\n• Snack: Greek yogurt or fresh fruit\n• Dinner: Lablabi or shorba + salad\n\nThis follows the Mediterranean pattern — proven to reduce chronic disease risk."

            // ── Products ──────────────────────────────────────────────────────
            "product" in q || "find" in q ->
                "🔍 Verified products: Use the HealthKey blockchain scanner to check product origin and nutritional certification. Scan the QR code on local market produce for full traceability from Tunisian farms."

            // ── Nutrition tips ────────────────────────────────────────────────
            "tip" in q || "advice" in q ->
                "💡 Top 5 Tunisian nutrition tips:\n1. Olive oil daily — anti-inflammatory powerhouse\n2. Harissa in moderation — capsaicin boosts metabolism\n3. Cumin in every dish — aids digestion\n4. Fresh herbs (coriander, parsley) — packed with micronutrients\n5. Eat your main meal at lunch, lighter at dinner"

            // ── Fallback ──────────────────────────────────────────────────────
            else ->
                "🌿 I'm here to help with nutrition advice tailored to the Tunisian diet! Try asking about:\n• Breakfast, lunch, or dinner ideas\n• Protein, iron, or sugar management\n• Heart health or weight goals\n• Finding verified local products"
        }
    }
}
