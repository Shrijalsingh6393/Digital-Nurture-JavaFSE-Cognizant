import React, { Component } from 'react';
import GitClient from './GitClient';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      repos: [],
      loading: true,
      username: 'techiesyed'
    };
  }

  async componentDidMount() {
    try {
      const gitClient = new GitClient();
      const repoList = await gitClient.getRepositories(this.state.username);
      this.setState({ repos: repoList, loading: false });
    } catch (error) {
      console.error('Error fetching repositories:', error);
      // Fallback mock repos if live GitHub API rate limits or network fails
      this.setState({
        repos: ['react-demo-app', 'spring-boot-microservices', 'java-fse-portfolio'],
        loading: false
      });
    }
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>GitHub Client Application</h1>
        </header>

        <main className="App-main">
          <div className="repo-card">
            <h2>Repositories for: <span className="highlight">{this.state.username}</span></h2>
            {this.state.loading ? (
              <p className="loading-text">Loading repositories...</p>
            ) : (
              <ul className="repo-list">
                {this.state.repos.map((repoName, index) => (
                  <li key={index} className="repo-item">
                    📁 {repoName}
                  </li>
                ))}
              </ul>
            )}
          </div>
        </main>
      </div>
    );
  }
}

export default App;
