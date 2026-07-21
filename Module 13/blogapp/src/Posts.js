import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMsg: ''
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        const postList = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
        this.setState({ hasError: true, errorMsg: error.message });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert(`Error occurred in Posts Component: ${error}`);
    console.error('Error caught by componentDidCatch:', error, info);
    this.setState({ hasError: true, errorMsg: error.toString() });
  }

  render() {
    if (this.state.hasError) {
      return (
        <div className="error-container">
          <h2>An error occurred while loading posts.</h2>
          <p>{this.state.errorMsg}</p>
        </div>
      );
    }

    return (
      <div className="posts-container">
        <h1 className="posts-header">Blog Posts</h1>
        {this.state.posts.length === 0 ? (
          <p className="loading">Loading posts from API...</p>
        ) : (
          this.state.posts.map((post) => (
            <div key={post.id} className="post-card">
              <h2 className="post-title">{post.title}</h2>
              <p className="post-body">{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Posts;
