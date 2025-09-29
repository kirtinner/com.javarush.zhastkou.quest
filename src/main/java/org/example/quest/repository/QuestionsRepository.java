package org.example.quest.repository;

import lombok.Getter;
import org.example.quest.model.Question;

import java.util.HashMap;
import java.util.Map;

@Getter
public class QuestionsRepository {
    private final Map<Integer, Question> questions;

    public QuestionsRepository() {
        this.questions = new HashMap<>();
        initializeQuestions();
    }

    protected void initializeQuestions() {
        // Follow-up questions
        questions.put(1, new Question(
                "Вы просыпаетесь на необитаемом острове. Перед вами два пути: пойти вглубь острова или остаться на берегу. Что вы выберете?",
                "Пойти вглубь острова", 2,
                "Остаться на берегу", 3
        ));

        questions.put(2, new Question(
                "В джунглях вы натыкаетесь на старую хижину. Зайти внутрь или обойти стороной?",
                "Зайти внутрь", 4,
                "Обойти стороной", 5
        ));

        questions.put(3, new Question(
                "На берегу вы находите бутылку с запиской. Прочитать ее или выбросить?",
                "Прочитать записку", 6,
                "Выбросить бутылку", 7
        ));

        questions.put(4, new Question(
                "В хижине вы находите карту сокровищ и лопату. Что делать?",
                "Взять карту и лопату", 8,
                "Оставить все как есть и уйти", 5
        ));

        questions.put(5, new Question(
                "Вы продолжаете бродить по острову и внезапно встречаете дикое животное. Ваши действия?",
                "Бежать прочь", 9,
                "Попытаться успокоить животное", 10
        ));

        questions.put(6, new Question(
                "В записке указаны координаты сокровищ. Что делать?",
                "Пойти искать сокровища", 8,
                "Игнорировать записку", 7
        ));

        questions.put(7, new Question(
                "Вы решаете не тратить время на поиски. Через несколько дней вас спасает проходящее судно.",
                false
        ));

        questions.put(8, new Question(
                "Вы находите место, указанное на карте, и начинаете копать. Вдруг из-за кустов появляется пират!",
                "Сражаться с пиратом", 11,
                "Попытаться договориться", 12
        ));

        // Final statements
        questions.put(9, new Question(
                "Вы успешно убегаете, но теряетесь в джунглях. Через неделю вас находят спасатели.",
                false
        ));

        questions.put(10, new Question(
                "Животное оказывается ручным. Оно ведет вас к пещере, где вы находите сундук с сокровищами!",
                true
        ));

        questions.put(11, new Question(
                "Вам удается одолеть пирата! За его поясом вы находите ключ от сундука с сокровищами.",
                true
        ));

        questions.put(12, new Question(
                "Пират соглашается разделить сокровища пополам. Вы становитесь богачом!",
                true
        ));
    }

    public Question getQuestion(int id) {
        return questions.get(id);
    }
}
