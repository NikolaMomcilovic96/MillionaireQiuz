package com.raywenderlich.milioner

data class Question(
    val question: String,
    val rightAnswer: String,
    val wrong1: String,
    val wrong2: String,
    val wrong3: String,
    val price: Int
)

val questions: ArrayList<Question> = arrayListOf(
    Question("In the UK, the abbreviation NHS stands for National what Service?",
        "Health",
        "Humanity",
        "Honour",
        "Household",
        100),
    Question("Which Disney character famously leaves a glass slipper behind at a royal ball?",
        "Cinderella",
        "Pocahontas",
        "Sleeping Beauty",
        "Elsa", 200),
    Question("What name is given to the revolving belt machinery in an airport that delivers checked luggage from the plane to baggage reclaim?",
        "Carousel",
        "Hangar",
        "Terminal",
        "Concourse", 300),
    Question("Which of these brands was chiefly associated with the manufacture of household locks?",
        "Chubb",
        "Phillips",
        "Flymo",
        "Ronseal", 500),
    Question("The hammer and sickle is one of the most recognisable symbols of which political ideology?",
        "Communism",
        "Republicanism",
        "Conservatism",
        "Liberalism", 1000),
    Question("Which toys have been marketed with the phrase “robots in disguise”?",
        "Transformers",
        "Bratz Dolls",
        "Sylvanian Families",
        "Hatchimals", 2000),
    Question("What does the word loquacious mean?", "Chatty", "Angry", "Beautiful", "Shy", 4000),
    Question("Obstetrics is a branch of medicine particularly concerned with what?",
        "Childbirth",
        "Broken bones",
        "Heart conditions",
        "Old age", 8000),
    Question("In Doctor Who, what was the signature look of the fourth Doctor, as portrayed by Tom Baker?",
        "Wide-brimmed hat and extra long scarf",
        "Bow-tie, braces and tweed jacket",
        "Pinstripe suit and trainers",
        "Cape, velvet jacket and frilly shirt", 16000),
    Question("Which of these religious observances lasts for the shortest period of time during the calendar year?",
        "Diwali",
        "Ramadan",
        "Lent",
        "Hanukkah", 32000),
    Question("At the closest point, which island group is only 50 miles south-east of the coast of Florida?",
        "Bahamas",
        "US Virgin Islands",
        "Turks and Caicos Islands",
        "Bermuda", 64000),
    Question("Construction of which of these famous landmarks was completed first?",
        "Big Ben Clock Tower",
        "Empire State Building",
        "Royal Albert Hall",
        "Eiffel Tower", 125000),
    Question("Which of these cetaceans is classified as a “toothed whale”?",
        "Sperm whale",
        "Gray whale",
        "Minke whale",
        "Humpback whale", 250000),
    Question("Who is the only British politician to have held all four “Great Offices of State” at some point during their career?",
        "James Callaghan",
        "David Lloyd George",
        "Harold Wilson",
        "John Major", 500000),
    Question("In 1718, which pirate died in battle off the coast of what is now North Carolina?",
        "Blackbeard",
        "Calico Jack",
        "Bartholomew Roberts",
        "Captain Kidd", 1000000)
)