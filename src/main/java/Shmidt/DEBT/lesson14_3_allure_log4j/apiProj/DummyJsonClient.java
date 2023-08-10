package Shmidt.DEBT.lesson14_3_allure_log4j.apiProj;

import java.io.IOException;

public interface DummyJsonClient {
    /** dummyjson.com/users/{id}
     * получение информации о пользователе по уникальному id (dummyjson.com/docs/users).  На сайте предустановлены пользователи с id от 1 до 100.
     * @param id
     * @return
     */
    Response getUser(int id) throws IOException;

    /** dummyjson.com/auth/login/
     * аутентификация пользователя по логину и паролю (dummyjson.com/docs/auth).  Логин и пароль возвращаются со всей информацией пользователя из пункта 1.
     * В ответе возвращается токен, который далее используется для отправки запросов.
     * @param u
     * @return
     */
    Response login(User u) throws IOException;

    /** dummyjson.com/auth/posts/{user.id}
     * получение списка сообщений по уникальному id пользователя, используя токен, полученный при аутентификации.
     * Токен передается через заголовок "Authorization"
     * (см. swagger.io/docs/specification/authentication/bearer-authentication/ и dummyjson.com/docs )
     * @param u
     * @param token
     * @return
     */
    Response getPosts(User u, Token token);
}
