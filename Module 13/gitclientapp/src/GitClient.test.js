import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockRepos = [
      { id: 1, name: 'react-demo-app' },
      { id: 2, name: 'spring-boot-microservices' },
      { id: 3, name: 'java-fse-portfolio' }
    ];

    // Mock axios.get response payload
    axios.get.mockResolvedValue({ data: mockRepos });

    const gitClient = new GitClient();
    const repos = await gitClient.getRepositories('techiesyed');

    expect(repos).toEqual(['react-demo-app', 'spring-boot-microservices', 'java-fse-portfolio']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
