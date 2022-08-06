package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Dashboard {

    public static void main(String[] args) throws IOException {
        ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
        reviewerDashboard.printReviewers();

        ParticipantDashboard participantDashboard = new ParticipantDashboard();
        participantDashboard.printUsernames(15);
    }

    public void printUsernames(int eventId) throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        // Get participants
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        // Print participants
        participants.forEach(System.out::println);
    }
}

/**
 * 메소드 올리기
 *
 * - 중복 코드는 당장은 잘 동작하더라도 미래에 버그를 만들어 낼 빌미를 제공한다.
 * ex) A에서 코드를 고치고, B에는 반영하지 않은 경우
 *
 * - 여러 하위 클래스에 동일한 코드가 있다면, 손쉽게 이 방법을 적용할 수 있다.
 *
 * - 비슷하지만 일부 값만 다른 경우라면, "함수 매개변수화하기" 리팩토링을 적용한 이후에, 이 방법을 사용할 수 있다.
 *
 * - 하위 클래스에 있는 코드가 상위 클래스가 아닌 하위 클래스 기능에 의존하고 있다면 "필드 올리기"를 적용한 이후에 이 방법을 적용할 수 있다.
 *
 * - 두 메소드가 비슷한 절차를 따르고 있다면, "템플릿 메소드 패턴" 적용을 고려할 수 있다.
 */