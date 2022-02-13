[Snack](https://xjrga.github.io/snack "Snack: Learning Software for Nutrition")

    Snack is learning software for nutrition, a meal design tool and calculator that
    could facilitate achieving your health goals and objectives by first helping you 
    understand your food intake and second by allowing you to create new food
    combinations that meet specific requirements.
    
    Snack is a training program designed to find lowest calorie food combination. It
    lets you experiment and get faster, better, less expensive results so you can 
    rapidly learn. Its intended audience is anyone with interest in nutrition.
    
    Home page: https://xjrga.github.io/snack
    Download: https://xjrga.github.io/releases/
    
    Features:
        - quantify food intake
        - track any nutrient or compound that has an impact on health
        - find food items that provide a specific nutrient
        - keep a food journal and track progress
        - compare two meals to see difference in nutritional value
        - compare meals against Required Daily Allowance (RDA) values
        - compare meals against Upper Limit (UL) values       
        - Export data and create reports in spreadsheet      
        - quantify any popular diet for comparison and research purposes       
        - annotate mixes
        - calculate basal metabolic rate (BMR)
        - calculate glycemic index (GI) and glycemic load (GL) of a meal
        - check glycemic index range
        - calculate food quotient (FQ)  
        - convert percent daily value (%DV) to grams
        - facilitate learning/teaching anyone with interest in nutrition
        - is free and open source
    
    Requirements:
       - Java 11

Installing

    1. Download snack-720-app.zip from https://xjrga.github.io/releases/
    2. unzip snack-720-app.zip
    3. cd snack-720
    4. java -jar snack-720.jar (if you are on windows double click on jar file) 
    
[User Guide](https://xjrga.github.io/snack "Snack: Learning Software for Nutrition")

Build

    720

Authors

[Jorge R Garcia de Alba](https://xjrga.github.io "Snack: Learning Software for Nutrition")

License

    This project is licensed under the GPLV2 License.

Acknowledgments

Snack uses the following libraries:

    commons-math3-3.6.1.jar
    hsqldb-2.6.1.jar (v2.5.1)
    jgoodies-common-1.8.1.jar
    jgoodies-forms-1.9.0.jar
    poi-4.0.1.jar    
   
Snack uses a data subset from:

    1) USDA National Nutrient Database for Standard Reference, Release 28
    
    2) Dietary Reference Intakes Nutrient Recommendations Report from 
       Food and Nutrition Board of the Institute of Medicine, 
       National Academy of Sciences

Comments

    I added inequality options to food nutrient ratio and nutrient ratio 
    constraints to make Snack less picky. The new fat percentages should
    allow for better diet analysis.
              