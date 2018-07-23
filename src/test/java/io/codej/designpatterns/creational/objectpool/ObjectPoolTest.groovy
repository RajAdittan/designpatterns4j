package io.codej.designpatterns.creational.objectpool

import java.util.stream.IntStream

class ObjectPoolTest extends GroovyTestCase {

    class Email extends PooledObject {
        private String from;
        private final List<String> to = new ArrayList<>();
        private String subject;
        private String body;String getFrom() {
            return from
        }

        void setFrom(String from) {
            this.from = from
        }

        List<String> getTo() {
            return to
        }

        void setTo(String to) {
            this.to.add(to);
        }

        String getSubject() {
            return subject
        }

        void setSubject(String subject) {
            this.subject = subject
        }

        String getBody() {
            return body
        }

        void setBody(String body) {
            this.body = body
        }

        @Override
        void reset() {
            from = "";
            to.clear();
            subject = "";
            body = "";
        }


        @Override
        public String toString() {
            return "Email{" + '\n' +
                    "from='" + from + '\'' + '\n' +
                    ", to=" + to + '\n' +
                    ", subject='" + subject + '\'' + '\n' +
                    ", body='" + body + '\'' + '\n' +
                    '}';
        }

        void send() {
            println toString();
        }
    }

    class Mailer implements ObjectPool.ClassFactory<Email> {
        @Override
        Email create() {
            return new Email();
        }
    }

    void testObjectPool() {
        ObjectPool.ClassFactory<Email> emailFactory = new Mailer();
        ObjectPool objectPool = new ObjectPool();
        List<Email> emails = new ArrayList<>();
        IntStream.range(0, 20).forEach( {
            Email email = objectPool.get(emailFactory);
            email.setFrom("from@gmail.com")
            email.setTo("this@gmail.com");
            email.setTo("that@gmail.com");
            email.setSubject("important text, read to end carefully");
            email.setBody("Poolable objects must meet certain requirements to enable a single object instance to be used by multiple clients.");
            emails.add(email);
        });


        while(emails.size() > 0 ) {
            Email email = emails.remove(0);
            email.send();
            objectPool.put(email);
            email.send();
        }
    }
}
