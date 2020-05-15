package self.terence.practice.practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import self.terence.practice.practice.dto.AccessTokenDto;
import self.terence.practice.practice.dto.GithubUser;
import self.terence.practice.practice.provide.GithubProvider;

@Controller
public class AuthController {

    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private AccessTokenDto accessTokenDto;
    @Value("${github.client_id}")
    private String client_id;
    @Value("${github.client_secret}")
    private String client_secret;
    @Value("${github.redirect_uri}")
    private String redirect_uri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
//        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(client_secret);
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setRedirect_uri(redirect_uri);
        String token = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUserInfo(token);
        System.out.print(user.getId());
        System.out.print(user.getLogin());
        return "index";
    }
}
