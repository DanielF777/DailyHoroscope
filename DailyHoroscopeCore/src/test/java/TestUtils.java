import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class TestUtils {

    static String horoscopesApiPayload() {
        return "{\n" +
                "  \"dailyhoroscope\": {\n" +
                "    \"Aries\": \"Challenges are good! They keep you going and committed - but that is not all. They are also what makes you grow.<a href=\\\"https://horoscopes-and-astrology.com/Aries\\\" alt=\\\"Aries\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Taurus\": \"Thoughts and ideas may be splendid - but they don't do anyone much good if you don't have the ability to transform them into actions.<a href=\\\"https://horoscopes-and-astrology.com/Taurus\\\" alt=\\\"Taurus\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Gemini\": \"You can spend a huge amount of energy thinking and worrying about how others see you - but... can't you just not care?<a href=\\\"https://horoscopes-and-astrology.com/Gemini\\\" alt=\\\"Gemini\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Cancer\": \"If you want to be given love and attention, you have to give love and attention. Even in these matters, it's an eye for an eye.<a href=\\\"https://horoscopes-and-astrology.com/Cancer\\\" alt=\\\"Cancer\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Leo\": \"Think twice about how you choose to express yourself. You choice of words can be very important to how your message is received.<a href=\\\"https://horoscopes-and-astrology.com/Leo\\\" alt=\\\"Leo\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Virgo\": \"You may be having some trouble telling a certain someone how you feel, and it is a constant and disturbing presence in your head.<a href=\\\"https://horoscopes-and-astrology.com/Virgo\\\" alt=\\\"Virgo\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Libra\": \"Even though you are a very sociable person with a lot of energy, you can't be everything to everyone. Be selective with your charms.<a href=\\\"https://horoscopes-and-astrology.com/Libra\\\" alt=\\\"Libra\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Scorpio\": \"You will benefit tremendously from talking to a friend about something that you might be considering a moral dilemma.<a href=\\\"https://horoscopes-and-astrology.com/Scorpio\\\" alt=\\\"Scorpio\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Sagittarius\": \"Today, you could be asked to take part in something that you really feel you neither are nor should be involved in. Just say no.<a href=\\\"https://horoscopes-and-astrology.com/Sagittarius\\\" alt=\\\"Sagittatius\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Capricorn\": \"Good friends don't grow on trees - when you have finally found them, be sure that you treat them well.<a href=\\\"https://horoscopes-and-astrology.com/Capricorn\\\" alt=\\\"Capricon\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Aquarius\": \"It might be difficult for you to hide your dissatisfaction with a decision made by someone else - this is not necessarily a bad thing.<a href=\\\"https://horoscopes-and-astrology.com/Aquarius\\\" alt=\\\"Aquarius\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\",\n" +
                "    \"Pisces\": \"Wouldn't it be a good idea to spend the day digging into your bad conscience - perhaps by contacting a long lost friend?<a href=\\\"https://horoscopes-and-astrology.com/Pisces\\\" alt=\\\"Pisces\\\" target=\\\"_blank\\\"> <i>Read more...</i></a>\"\n" +
                "  },\n" +
                "  \"dates\": {\n" +
                "    \"Aries\": \"March 21 - April 19\",\n" +
                "    \"Taurus\": \"April 20 - May 20\",\n" +
                "    \"Gemini\": \"May 21 - June 20\",\n" +
                "    \"Cancer\": \"June 21 - July 22\",\n" +
                "    \"Leo\": \"July 23 - August 22\",\n" +
                "    \"Virgo\": \"August 23 - September 22\",\n" +
                "    \"Libra\": \"September 23 - October 22\",\n" +
                "    \"Scorpio\": \"October 23 - November 21\",\n" +
                "    \"Sagittarius\": \"November 22 - December 21\",\n" +
                "    \"Capricorn\": \"December 22 - January 19\",\n" +
                "    \"Aquarius\": \"January 20 - February 18\",\n" +
                "    \"Pisces\": \"February 19 - March 20\"\n" +
                "  },\n" +
                "  \"DeliveredBy\": \"Horoscopes-and-astrology.com\"\n" +
                "}";
    }

    static Map<String, String> dailyhoroscope() {
        Map<String, String> dailyhoroscope = new HashMap<>();
        dailyhoroscope.put("Aries", "Challenges are good! They keep you going and committed - but that is not all. They are also what makes you grow.<a href=\"https://horoscopes-and-astrology.com/Aries\" alt=\"Aries\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Taurus", "Thoughts and ideas may be splendid - but they don't do anyone much good if you don't have the ability to transform them into actions.<a href=\"https://horoscopes-and-astrology.com/Taurus\" alt=\"Taurus\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Gemini", "You can spend a huge amount of energy thinking and worrying about how others see you - but... can't you just not care?<a href=\"https://horoscopes-and-astrology.com/Gemini\" alt=\"Gemini\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Cancer", "If you want to be given love and attention, you have to give love and attention. Even in these matters, it's an eye for an eye.<a href=\"https://horoscopes-and-astrology.com/Cancer\" alt=\"Cancer\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Leo", "Think twice about how you choose to express yourself. You choice of words can be very important to how your message is received.<a href=\"https://horoscopes-and-astrology.com/Leo\" alt=\"Leo\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Virgo", "You may be having some trouble telling a certain someone how you feel, and it is a constant and disturbing presence in your head.<a href=\"https://horoscopes-and-astrology.com/Virgo\" alt=\"Virgo\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Libra", "Even though you are a very sociable person with a lot of energy, you can't be everything to everyone. Be selective with your charms.<a href=\"https://horoscopes-and-astrology.com/Libra\" alt=\"Libra\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Scorpio", "You will benefit tremendously from talking to a friend about something that you might be considering a moral dilemma.<a href=\"https://horoscopes-and-astrology.com/Scorpio\" alt=\"Scorpio\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Sagittarius", "Today, you could be asked to take part in something that you really feel you neither are nor should be involved in. Just say no.<a href=\"https://horoscopes-and-astrology.com/Sagittarius\" alt=\"Sagittatius\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Capricorn", "Good friends don’t grow on trees - when you have finally found them, be sure that you treat them well.<a href=\"https://horoscopes-and-astrology.com/Capricorn\" alt=\"Capricon\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Aquarius", "It might be difficult for you to hide your dissatisfaction with a decision made by someone else - this is not necessarily a bad thing.<a href=\"https://horoscopes-and-astrology.com/Aquarius\" alt=\"Aquarius\" target=\"_blank\"> <i>Read more...</i></a>");
        dailyhoroscope.put("Pisces", "Wouldn’t it be a good idea to spend the day digging into your bad conscience - perhaps by contacting a long lost friend?<a href=\"https://horoscopes-and-astrology.com/Pisces\" alt=\"Pisces\" target=\"_blank\"> <i>Read more...</i></a>");
        return dailyhoroscope;
    }

    static Map<String, String> dates() {
        Map<String, String> dates = new HashMap<>();
        dates.put("Aries", "March 21 - April 19");
        dates.put("Taurus", "April 20 - May 20");
        dates.put("Gemini", "May 21 - June 20");
        dates.put("Cancer", "June 21 - July 22");
        dates.put("Leo", "July 23 - August 22");
        dates.put("Virgo", "August 23 - September 22");
        dates.put("Libra", "September 23 - October 22");
        dates.put("Scorpio", "October 23 - November 21");
        dates.put("Sagittarius", "November 22 - December 21");
        dates.put("Capricorn", "December 22 - January 19");
        dates.put("Aquarius", "January 20 - February 18");
        dates.put("Pisces", "February 19 - March 20");
        return dates;
    }

}
